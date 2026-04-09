import java.io.*;
import java.util.*;

public class Main{

    public static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int mod = 10007;

        dp = new long[N+1][10];

        for(int i = 0; i < 10; i++){
            dp[1][i] = 1;
        }

        for(int i = 2; i <= N; i++){
            for(int j = 0; j < 10; j++){
                for(int k = 0; k <= j; k++){
                    dp[i][j] = (dp[i][j] + dp[i-1][k]) % mod;
                }
            }
        }

        int result = 0;

        for(int i = 0 ;i < 10; i++)
            result += dp[N][i];

        System.out.println(result%mod);

    }

}