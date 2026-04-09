import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static boolean[] visitied;
	static ArrayList<Integer>[] arr;

	public Main() throws IOException {
		int N = Integer.parseInt(bf.readLine());
		int connect_number = Integer.parseInt(bf.readLine());

		visitied = new boolean[N + 1];
		arr = new ArrayList[N + 1];

		setBridge(N, connect_number);
		System.out.print(dfs(1) - 1);
	}

	public void setBridge(int N, int connect) throws IOException {
		for(int i=1;i<=N;i++) {
			arr[i] = new ArrayList<>();
		}
		
		for(int i=1;i<=connect;i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			arr[u].add(v);
			arr[v].add(u);
		}
	}
	
	public int dfs(int node) {
		if(visitied[node])
			return 0;
		visitied[node] = true;
		int count = 1;
		for(int i : arr[node]) {
			if(visitied[i] == false) {
				count += dfs(i);
			}
		}
		return count;
	}

	public static void main(String[] args) throws IOException {
		new Main();
	}
}
