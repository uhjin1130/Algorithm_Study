import java.io.*;
import java.util.*;

public class Main {
    public static int w, h;
    public static int[][] map;
    public static boolean[][] visited;
    public static int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
    public static int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0)
                break;

            visited = new boolean[h][w];
            map = new int[h][w];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int islandCnt = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        bfs(i, j);
                        islandCnt++;
                    }
                }
            }
            System.out.println(islandCnt);
        }
    }

    public static void bfs(int sy, int sx) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { sy, sx });
        visited[sy][sx] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cy = cur[0], cx = cur[1];

            for (int d = 0; d < 8; d++) {
                int ny = cy + dx[d]; // dx로 행
                int nx = cx + dy[d]; // dy로 열
                if (ny >= 0 && ny < h && nx >= 0 && nx < w
                        && !visited[ny][nx] && map[ny][nx] == 1) {
                    visited[ny][nx] = true;
                    queue.offer(new int[] { ny, nx });
                }
            }
        }
    }
}