import java.util.*;
import java.io.*;

public class Main {
    public static int[] dp;
    public static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dp = new int[N+1];
        dp[0] = dp[1] = 0;

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + 1; // 1을 뺀값
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1); // 1을 뺀값과 2로 나눈값준 최솟값
            }
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1); // (1을 뺀 값과 2로 나눈 값중 최솟값) 과 3으로 나눈값중 최솟값
            }
        }

        System.out.println(dp[N]);

    } // main
} // class