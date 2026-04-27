import java.util.*;
import java.io.*;

public class Main {
    public static int N, M, V;
    public static int[][] nodes;
    public static boolean[] visited;
    public static Queue<Integer> queue = new LinkedList<>();
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        nodes = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        int a, b;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            nodes[a][b] = nodes[b][a] = 1;
        }

        dfs(V);
        sb.append("\n");

        visited = new boolean[N + 1];
        bfs(V);

        System.out.println(sb.toString());
    }

    public static void dfs(int start) {
        visited[start] = true;
        sb.append(start + " ");

        for (int i = 1; i <= N; i++) {
            if (!visited[i] && nodes[start][i] == 1)
                dfs(i);
        }
    }

    public static void bfs(int start){
        visited[start] = true;
        queue.add(start);

        while(!queue.isEmpty()) {
            start = queue.poll();
            sb.append(start + " ");
            for(int i = 1; i <= N; i++){
                if(!visited[i] && nodes[start][i] == 1) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}