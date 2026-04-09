import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private int x;
	private int dp[];

	public Main() throws IOException {
		StringTokenizer st = new StringTokenizer(bf.readLine());
		x = Integer.parseInt(st.nextToken());
		dp = new int[x + 1];
		dp[0] = dp[1] = 0;
		
		caculate();
		System.out.print(dp[x]);

	}

	public void caculate() {
		for (int i = 2; i <= x; i++) {
			dp[i] = dp[i - 1] + 1;
			if (i % 2 == 0 && dp[i] > dp[i / 2] + 1) {
				dp[i] = dp[i/2] + 1;
			}
			if (i % 3 == 0 && dp[i] > dp[i / 3] + 1) {
				dp[i] = dp[i/3] + 1;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		new Main();
	}
}
