import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private int dp[];

	public Main() throws IOException {
		int n = Integer.parseInt(bf.readLine());

		dp = new int[n + 1];
		dp[0] = 0;
		dp[1] = 1;

		
		for (int i = 2; i <= n; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 1; j * j <= i; j++) {
				min = Math.min(min, dp[i - j * j]);
			}
			dp[i] = min + 1;
		}
		
		System.out.print(dp[n]);

	}

	public static void main(String[] args) throws IOException {
		new Main();
	}
}
