import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 0; test_case < T; test_case++) {
            int N = Integer.parseInt(br.readLine());

            int[][] score = new int[3][N + 1];
            Arrays.fill(score[0], 0);
            score[1][0] = 0;
            score[2][0] = 0;

            for (int i = 1; i <= 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= N; j++) {
                    score[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] dp = new int[3][N + 1];
            Arrays.fill(dp[0], 0);

            if (N == 1) {
                dp[1][1] = score[1][1];
                dp[2][1] = score[2][1];
                System.out.println(Math.max(dp[1][1], dp[2][1]));
                continue;
            }

            dp[1][1] = score[1][1];
            dp[2][1] = score[2][1];
            dp[1][2] = dp[2][1] + score[1][2];
            dp[2][2] = dp[1][1] + score[2][2];

            if (N == 2) {
                System.out.println(Math.max(dp[1][2], dp[2][2]));
                continue;
            }

            for (int j = 3; j <= N; j++) {
                dp[1][j] = Math.max(dp[2][j - 1], dp[2][j - 2]) + score[1][j];
                dp[2][j] = Math.max(dp[1][j - 1], dp[1][j - 2]) + score[2][j];
            }
            System.out.println(Math.max(dp[1][N], dp[2][N]));


        }
    }
}