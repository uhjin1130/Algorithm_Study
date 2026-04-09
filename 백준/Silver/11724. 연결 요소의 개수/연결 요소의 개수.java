import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private boolean visit[];
	static int graph[][];
	static int N, M;
	private int count = 0;

	public Main() throws IOException {
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		visit = new boolean[N + 1];
		graph = new int[N + 1][N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			graph[u][v] = graph[v][u] = 1;
		}

		// 시작 노드를 1로 변경
        for (int i = 1; i <= N; i++) {
            if (!visit[i]) {
                dfs(i);
                count++;
            }
        }
		System.out.print(count);
	}

	public void dfs(int start) {
        visit[start] = true;

        for (int i = 1; i <= N; i++) {
            if (!visit[i] && graph[start][i] != 0) {
                dfs(i);
            }
        }
    }

	public static void main(String[] args) throws IOException {
		new Main();
	}
}
