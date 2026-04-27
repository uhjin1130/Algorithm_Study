import java.util.*;
import java.io.*;

public class Main {
    public static int N, M, cnt;
    public static int[][] computers;
    public static boolean[] visitied;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        computers = new int[N + 1][N + 1];
        visitied = new boolean[N + 1];

        for (int i = 1; i <= M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            computers[a][b] = computers[b][a] = 1;
        }

        cnt = 0;
        dfs(1);

        System.out.println(cnt);
    }

    public static void dfs(int node) {
        visitied[node] = true;

        for (int i = 1; i <= N; i++) {
            if (!visitied[i] && computers[node][i] == 1) {
                cnt++;
                dfs(i);
            }
        }
    }

}