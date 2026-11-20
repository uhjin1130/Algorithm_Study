import java.util.*;

public class Main {

    public static int n, m;
    public static int[][] map;
    public static int[][] answer;
    public static boolean[][] visited;
    public static int[] dx = {0, 1};
    public static int[] dy = {1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[n][m];
        answer = new int[n][m];
        visited = new boolean[n][m];
        visited[0][0] = true;

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                map[i][j] = sc.nextInt();
        // Please write your code here.
        
        dfs(0, 0);

        if(answer[n - 1][m - 1] == 0)
            System.out.print(0);
        else
            System.out.print(1);
    }

    public static void dfs(int x, int y) {
        for(int i = 0; i < 2; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= m || ny >= n || map[ny][nx] == 0 ||visited[ny][nx])
                continue;
            else {
                answer[ny][nx] = answer[y][x] + 1;
                visited[ny][nx] = true;
                dfs(nx, ny);
            }
        }
    }
}