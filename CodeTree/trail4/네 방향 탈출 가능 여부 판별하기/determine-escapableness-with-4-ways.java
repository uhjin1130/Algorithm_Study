import java.util.*;

public class Main {

    public static int n, m;
    public static int[][] map;
    public static boolean[][] visited;
    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                map[i][j] = sc.nextInt();
        // Please write your code here.

        visited[0][0] = true;

        bfs();

        if(visited[n - 1][m - 1])
            System.out.print(1);
        else
            System.out.print(0);
        
    }

    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});

        while(!queue.isEmpty()) {
            int[] xy = queue.poll();
            int x = xy[0];
            int y = xy[1];

            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= m || ny >= n || visited[ny][nx] || map[ny][nx] == 0)
                    continue;

                visited[ny][nx] = true;
                queue.add(new int[] {nx, ny});
            }
        }
    }
}