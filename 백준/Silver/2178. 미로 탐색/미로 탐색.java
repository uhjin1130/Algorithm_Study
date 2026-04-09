import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int[][] map;
    public static int n, m;
    public static boolean[][] visited;
    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        bfs(0,0);
        System.out.println(map[n-1][m-1]);
    }

    public static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Point currentPoint = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newX = currentPoint.x + dx[i];
                int newY = currentPoint.y + dy[i];

                if(newX < 0 || newX >= n || newY < 0 || newY >= m) continue;
                if(map[newX][newY] == 0) continue;
                if(visited[newX][newY]) continue;
                visited[newX][newY] = true;
                queue.add(new Point(newX, newY));
                map[newX][newY] = map[currentPoint.x][currentPoint.y] + 1;
            }
        }
    }
}
