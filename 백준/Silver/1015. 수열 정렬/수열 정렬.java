import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

	public Main() throws IOException {
		
		int N = Integer.parseInt(bf.readLine());

		int[] P = new int[N];
		int[] A = new int[N];
		boolean[] visited = new boolean[N];

		if (N > 0 && N <= 50) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int i = 0; i < N; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < N; i++) {
				int min = Integer.MAX_VALUE;
				int minidx = -1;

				for (int j = 0; j < N; j++) {
					if (visited[j])
						continue;

					if (min > A[j]) {
						min = A[j];
						minidx = j;
					}
				}

				P[minidx] = i;
				visited[minidx] = true;
			}

			for (int k = 0; k < N; k++) {
				System.out.print(P[k] + " ");
			}
		}
	}

	public static void main(String[] args) throws IOException {
		new Main();
	}
}
