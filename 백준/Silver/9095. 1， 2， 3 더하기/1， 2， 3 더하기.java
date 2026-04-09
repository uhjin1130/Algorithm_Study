import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private int dp[] = new int[11];

	public Main() throws IOException {
		int T = Integer.parseInt(bf.readLine());

		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;

		for (int i = 4; i <= 10; i++) {
			dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
		}
		
		for(int i=0;i<T;i++) {
			int N = Integer.parseInt(bf.readLine());
			System.out.println(dp[N]);

		}
		
		bf.close();
	}

	public static void main(String[] args) throws IOException {
		new Main();
	}
}
