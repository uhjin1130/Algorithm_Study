import java.io.*;
import java.util.*;

public class Main {
    public static char[][] map;
    public static boolean[][] visited;
    public static int[] dx = { 0, 0, -1, 1 };
    public static int[] dy = { -1, 1, 0, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String mapInfo = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = mapInfo.charAt(j);
                if (map[i][j] == 'I') {
                    q.add(new int[] { i, j });
                    visited[i][j] = true;
                }
            }
        }

        int count = 0;

        while (!q.isEmpty()) {
            int[] t = q.poll();
            int y = t[0];
            int x = t[1];
            visited[y][x] = true;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (ny < 0 || nx < 0 || ny >= n || nx >= m || map[ny][nx] == 'X' || visited[ny][nx])
                    continue;
                if (map[ny][nx] == 'P' && !visited[ny][nx]) {
                    count++;
                    q.add(new int[] { ny, nx });
                }
                if (map[ny][nx] == 'O' && !visited[ny][nx]) {
                    q.add(new int[] { ny, nx });
                }
                visited[ny][nx] = true;
            }
        }

        if (count == 0)
            System.out.println("TT");
        else
            System.out.println(count);
    }
}
