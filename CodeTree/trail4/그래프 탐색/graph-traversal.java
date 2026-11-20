import java.util.*;
public class Main {
    public static boolean[] visited;
    public static int[][] nodes;
    public static int cnt = 0;
    public static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        nodes = new int[n + 1][n + 1];

        for(int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            nodes[a][b] = 1;
            nodes[b][a] = 1;
        }

        // Please write your code here.
        visited = new boolean[n + 1];
        visited[1] = true;
        dfs(1);
        System.out.println(cnt);
    }

    public static void dfs(int cur) {
        for(int next = 1; next <= n; next++) {
            if(nodes[cur][next] == 1 && !visited[next]) {
                visited[next] = true;
                cnt++;
                dfs(next);
            }
        }
    }
}