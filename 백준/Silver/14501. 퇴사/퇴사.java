import java.io.*;
import java.util.*;

public class Main {
    public static int[] T, P;
    public static int N, max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        T = new int[N + 1];
        P = new int[N + 1];

        T[0] = P[0] = 0;

        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        findMax(0, 1);
        System.out.println(max);

    }

    public static void findMax(int sum, int day){
        if(day > N + 1)
            return;
        if(day == N + 1) {
            max = Math.max(max, sum);
            return;
        }

        findMax(sum, day + 1);

        if(day + T[day] <= N + 1) {
            findMax(sum + P[day], day + T[day]);
        }
    }
}