import java.io.*;
import java.util.*;

public class Main {
    static public int magicA;
    static public int magicB;
    static public int n;
    static public int m;
    static public int[] arr;
    static public int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        magicA = Integer.parseInt(st.nextToken());
        magicB = Integer.parseInt(st.nextToken());

        arr = new int[n + 1];
        int left, right;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            left = Integer.parseInt(st.nextToken());
            right = Integer.parseInt(st.nextToken());

            arr[left] -= 1;
            arr[right + 1] += 1;
        }

        for (int i = 1; i < n + 1; i++) {
            arr[i] += arr[i - 1];
        }

        dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < n + 1; i++) {
            if (arr[i] < 0 || dp[i] == Integer.MAX_VALUE)
                continue;
            if (i + magicA <= n) {
                dp[i + magicA] = Math.min(dp[i + magicA], dp[i] + 1);
            }
            if (i + magicB <= n) {
                dp[i + magicB] = Math.min(dp[i + magicB], dp[i] + 1);
            }
        }

        if (dp[n] == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(dp[n]);
    }
}
