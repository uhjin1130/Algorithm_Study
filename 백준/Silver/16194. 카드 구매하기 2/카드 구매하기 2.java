import java.io.*;
import java.util.*;

public class Main {
    public static int[] dp;
    public static int[] cardPack;
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N+1];
        cardPack = new int[N+1];
        cardPack[0] = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=N;i++){
            cardPack[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(dp,10000);
        dp[0] = 0;

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= i; j++){
                dp[i] = Math.min(dp[i], dp[i-j] + cardPack[j]);
            }
        }
        System.out.println(dp[N]);


    }

}