import java.io.*;
import java.util.*;

public class Main {

    static int N, M, map[][], max;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, 1, map[i][j]);
                find(i, j);
                visited[i][j] = false;
            }
        }
        System.out.println(max);


    }

    private static void dfs(int x, int y, int cnt, int sum) {
        if (cnt == 4) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if (visited[nx][ny]) continue;

            visited[nx][ny] = true;
            dfs(nx, ny, cnt + 1, sum + map[nx][ny]);
            visited[nx][ny] = false;
        }
    }

    private static void find(int i, int j) {
        // ㅏ
        if (i - 1 >= 0 && i + 1 < N && j + 1 < M) {
            int sum = map[i][j] + map[i - 1][j] + map[i + 1][j] + map[i][j + 1];
            max = Math.max(max, sum);
        }
        // ㅓ
        if (i - 1 >= 0 && i + 1 < N && j - 1 >= 0) {
            int sum = map[i][j] + map[i - 1][j] + map[i + 1][j] + map[i][j - 1];
            max = Math.max(sum, max);
        }
        //ㅗ
        if (i - 1 >= 0 && j - 1 >= 0 & j + 1 < M) {
            int sum = map[i][j] + map[i - 1][j] + map[i][j - 1] + map[i][j + 1];
            max = Math.max(sum, max);
        }
        //ㅜ
        if (i + 1 < N && j - 1 >= 0 & j + 1 < M) {
            int sum = map[i][j] + map[i + 1][j] + map[i][j - 1] + map[i][j + 1];
            max = Math.max(sum, max);
        }
    }
}