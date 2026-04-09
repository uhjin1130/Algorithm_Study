import java.io.*;
import java.util.*;

public class Main{

    public static int dp[];
    public static int coin[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        coin = new int[n];
        dp = new int[k+1];

        Arrays.fill(dp, 100001);
        dp[0] = 0;

        for(int i = 0 ; i < n; i++){
            coin[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 0; i < n; i++){
            int now = coin[i];
            for(int j = now ; j <= k; j++){
                dp[j] = Math.min(dp[j], dp[j-now]+1);
            }
        }

        if(dp[k] == 100001){
            System.out.println(-1);
        } else
            System.out.println(dp[k]);

    }

}