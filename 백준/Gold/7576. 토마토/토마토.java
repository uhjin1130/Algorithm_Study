import java.io.*;
import java.util.*;

public class Main {
    public static int[][] box;
    public static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken()); // 가로 크기 (열의 수)
        n = Integer.parseInt(st.nextToken()); // 세로 크기 (행의 수)

        box = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        int[] dx = { 0, 0, -1, 1 }; // 좌우 이동
        int[] dy = { -1, 1, 0, 0 }; // 상하 이동

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) {
                    q.add(new int[] { i, j });
                }
            }
        }

        while (!q.isEmpty()) {
            int[] t = q.poll();
            int x = t[1];
            int y = t[0];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    if (box[ny][nx] == 0) {
                        box[ny][nx] = box[y][x] + 1;
                        q.add(new int[] { ny, nx });
                    }
                }
            }
        }

        if (check()) {
            System.out.println(-1);
        } else {
            int max = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (box[i][j] > max) {
                        max = box[i][j];
                    }
                }
            }
            System.out.println(max - 1);
        }
    }

    public static boolean check() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (box[i][j] == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
