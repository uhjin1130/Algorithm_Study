import java.util.*;
import java.io.*;

public class Main {
    public static int N = 1, t = 1;
    public static int[] dx = { 0, 0, -1, 1 };
    public static int[] dy = { -1, 1, 0, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while ((N = Integer.parseInt(br.readLine())) != 0) {
            int[][] map = new int[N][N];
            int[][] dist = new int[N][N];

            for (int[] row : dist)
                Arrays.fill(row, Integer.MAX_VALUE);

            StringTokenizer st;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
            dist[0][0] = map[0][0];
            queue.add(new int[] { map[0][0], 0, 0 });
            while (!queue.isEmpty()) {
                int[] cur = queue.poll();
                int cost = cur[0];
                int x = cur[1];
                int y = cur[2];

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (nx < 0 || ny < 0 || nx >= N || ny >= N)
                        continue;
                    int newCost = cost + map[ny][nx];
                    if (newCost < dist[ny][nx]) {
                        dist[ny][nx] = newCost;
                        queue.add(new int[] { newCost, nx, ny });
                    }

                }
            }

            System.out.println("Problem " + (t++) + ": " + dist[N - 1][N - 1]);
        }
    }

}