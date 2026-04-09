import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        final int MOD = 1000000009;
        final int MAXN = 1000000;
        long[] dp = new long[MAXN + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int j = 4; j <= MAXN; j++) {
            dp[j] = (dp[j - 1] + dp[j - 2] + dp[j - 3]) % MOD;
        }
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp[n]);
        }
    }
}