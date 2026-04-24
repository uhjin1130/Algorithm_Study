import java.io.*;
import java.util.*;

public class Main {
    public static int N, M, cnt = 0;
    public static int[] buildings;

    public static int unionFind(int classNum) {
        if (buildings[classNum] == classNum)
            return classNum;
        else
            return buildings[classNum] = unionFind(buildings[classNum]);

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        buildings = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            buildings[i] = i;
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = unionFind(Integer.parseInt(st.nextToken()));
            int b = unionFind(Integer.parseInt(st.nextToken()));

            if (a != b)
                buildings[a] = b;
        }

        int[] schedule = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            schedule[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N - 1; i++) {
            int fa = unionFind(schedule[i]);
            int fb = unionFind(schedule[i + 1]);
            if (fa != fb)
                cnt++;
        }

        System.out.println(cnt);

    }

}