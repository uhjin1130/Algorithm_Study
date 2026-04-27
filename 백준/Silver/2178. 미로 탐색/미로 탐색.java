import java.util.*;
import java.io.*;

public class Main {
    public static int N, M;
    public static int[] dx = { 0, 0, -1, 1 };
    public static int[] dy = { -1, 1, 0, 0 };
    public static int[][] map;
    public static boolean[][] visited;
    public static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            String s = br.readLine();
            for (int j = 1; j <= M; j++) {
                map[i][j] = s.charAt(j - 1) - '0';
            }
        }

        map[1][1] = 1;
        bfs(1, 1);

        System.out.println(map[N][M]);
    }

    public static void bfs(int x, int y) {
        visited[y][x] = true;
        queue.add(new int[] { x, y });

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (ny < 1 || nx < 1 || ny > N || nx > M)
                    continue;

                if (!visited[ny][nx] && map[ny][nx] > 0) {
                    visited[ny][nx] = true;
                    queue.add(new int[] { nx, ny });
                    map[ny][nx] = map[cur[1]][cur[0]] + 1;
                }

            }
        }
    }

}