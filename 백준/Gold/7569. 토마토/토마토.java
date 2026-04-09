import java.io.*;
import java.util.*;

public class Main {
    public static int[] dx = { 0, 0, -1, 1, 0, 0 };
    public static int[] dy = { -1, 1, 0, 0, 0, 0 };
    public static int[] dz = { 0, 0, 0, 0, -1, 1 };
    public static int m, n, h;
    public static int box[][][];
    public static Queue<Tomato> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken()); // columns
        n = Integer.parseInt(st.nextToken()); // rows
        h = Integer.parseInt(st.nextToken()); // height

        box = new int[h][n][m];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                    if (box[i][j][k] == 1) {
                        queue.add(new Tomato(i, j, k));
                    }
                }
            }
        }

        System.out.println(bfs());
    }

    public static int bfs() {
        while (!queue.isEmpty()) {
            Tomato current = queue.poll();

            int col = current.getX();
            int row = current.getY();
            int height = current.getZ();

            for (int i = 0; i < 6; i++) {
                int moveCol = col + dx[i];
                int moveRow = row + dy[i];
                int moveHeight = height + dz[i];
                if (moveRow >= 0 && moveRow < n && moveCol >= 0 && moveCol < m && moveHeight >= 0 && moveHeight < h) {
                    if (box[moveHeight][moveRow][moveCol] == 0) {
                        queue.add(new Tomato(moveHeight, moveRow, moveCol));
                        box[moveHeight][moveRow][moveCol] = box[height][row][col] + 1;
                    }
                }
            }
        }

        int result = Integer.MIN_VALUE;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (box[i][j][k] == 0)
                        return -1;
                    result = Math.max(result, box[i][j][k]);
                }
            }
        }
        return result - 1;
    }
}

class Tomato {
    private int x, y, z;

    public Tomato(int z, int y, int x) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }
}
