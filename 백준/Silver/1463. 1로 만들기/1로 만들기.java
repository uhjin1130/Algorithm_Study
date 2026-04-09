import java.io.*;
import java.util.*;

public class Main {
    public static int MAX = 1000000;

    public static int[] dp;
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dp = new int[N + 1];
        dp[0] = dp[1] = 0;

        calculate();
        System.out.println(dp[N]);

    }

    public static void calculate() {
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + 1;
            if (i % 2 == 0 && dp[i] > dp[i / 2] + 1)
                dp[i] = dp[i / 2] + 1;
            if (i % 3 == 0 && dp[i] > dp[i / 3] + 1)
                dp[i] = dp[i / 3] + 1;
        }
    }
    
}