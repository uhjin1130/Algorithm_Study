import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] dp = new int[n+1][k+1];
        for(int i = 0; i < n+1; i++){
            dp[i][0] = 0;
        }

        int[] weight = new int[n+1];
        int[] value = new int[n+1];
        weight[0] = 0;
        value[0] = 0;

        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            weight[i] = w;
            value[i] = v;
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= k; j++){
                if(j>=weight[i])
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - weight[i]] + value[i]);
                else
                    dp[i][j] = dp[i-1][j];
            }
        }

        System.out.println(dp[n][k]);

    }

}