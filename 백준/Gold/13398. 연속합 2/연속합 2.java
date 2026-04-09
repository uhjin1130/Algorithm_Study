import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[][] dp = new int[N][2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0][0] = dp[0][1] = arr[0];

        int result = arr[0];
        for(int i = 1; i < N; i++){
            dp[i][0] = Math.max(dp[i-1][0] + arr[i], arr[i]);
            dp[i][1] = Math.max(dp[i-1][0], dp[i-1][1] + arr[i]);

            result = Math.max(result, Math.max(dp[i][0], dp[i][1]));
        }

        System.out.println(result);


    }
}