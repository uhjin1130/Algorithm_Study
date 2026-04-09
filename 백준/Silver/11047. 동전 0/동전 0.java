import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	int coins[];

	public Main() throws IOException {
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		setCoin(N);
		getMin(N, K);
	}

	public void setCoin(int N) throws IOException {
		coins = new int[N];
		for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(bf.readLine());
        }
	}

	public void getMin(int N, int K) {
		int dp[] = new int[K + 1];
		for (int i = 1; i <= K; i++) {
            dp[i] = 100000001; // 최대 동전 개수보다 큰 값으로 초기화
        }
		for (int i = 0; i < N; i++) {
			for (int j = coins[i]; j <= K; j++) {
				dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
			}
		}
		
		// 만약 K원을 만들 수 없는 경우 -1 출력
        if (dp[K] == 100000001) {
            System.out.println(-1);
        } else {
            // 결과 출력
            System.out.println(dp[K]);
        }
	}

	public static void main(String[] args) throws IOException {
		new Main();
	}
}
