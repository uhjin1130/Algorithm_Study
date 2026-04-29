import java.util.*;
import java.io.*;

public class Main {
    public static int N, L, R, result;
    public static int[][] map;
    public static boolean[][] visited;
    public static int[] dx = { 0, 0, -1, 1 };
    public static int[] dy = { -1, 1, 0, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            visited = new boolean[N][N];
            boolean isMove = false;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        if (bfs(i, j))
                            isMove = true;
                    }
                }
            }
            if (!isMove)
                break;
            result++;
        }
        System.out.println(result);
    }

    public static boolean bfs(int x, int y) {
        List<int[]> union = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[] { x, y });
        visited[x][y] = true;
        union.add(new int[] { x, y });
        int sum = map[x][y];

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny]) {
                    int diff = Math.abs(map[cur[0]][cur[1]] - map[nx][ny]);
                    if (diff >= L && diff <= R) {
                        visited[nx][ny] = true;
                        queue.add(new int[] { nx, ny });
                        union.add(new int[] { nx, ny });
                        sum += map[nx][ny];
                    }
                }
            }
        }

        if (union.size() > 1) {
            int avg = sum / union.size();
            for (int[] pos : union)
                map[pos[0]][pos[1]] = avg;
            return true;
        }
        return false;
    }
}