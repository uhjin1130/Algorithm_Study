import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] rgb = new int[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                rgb[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 100000000;
        for (int firstColor = 0; firstColor < N; firstColor++) {
            int[][] dp = new int[N][3];

            dp[0][0] = (firstColor == 0) ? rgb[0][0] : 1001;
            dp[0][1] = (firstColor == 1) ? rgb[0][1] : 1001;
            dp[0][2] = (firstColor == 2) ? rgb[0][2] : 1001;

            for(int i = 1; i < N; i++) {
                dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + rgb[i][0];
                dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + rgb[i][1];
                dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + rgb[i][2];
            }

            for(int lastColor = 0; lastColor < 3; lastColor++) {
                if(lastColor!=firstColor)
                    result = Math.min(result, dp[N-1][lastColor]);

            }
        }

        System.out.println(result);

    }
}