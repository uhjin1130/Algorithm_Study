import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m; // 세로, 가로

    static class Graph {
        private int Map[][];
        private boolean visit[][];
        private Queue<Point> queue;
        private int dirX[] = {0, 0, -1, 1}; // 위, 아래, 왼쪽, 오른쪽
        private int dirY[] = {-1, 1, 0, 0}; // 위, 아래, 왼쪽, 오른쪽
        private int startX, startY;
        private int result[][];

        public Graph() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            visit = new boolean[n][m];
            Map = new int[n][m];
            queue = new LinkedList<>();

            result = new int[n][m];

            setMap(br);
            setResult();
            getResult();
        }

        public void setMap(BufferedReader br) throws IOException {
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    Map[i][j] = Integer.parseInt(st.nextToken());
                    if (Map[i][j] == 2) {
                        startX = j;
                        startY = i;
                    }
                }
            }
        }

        public void setResult() {
            int x = startX;
            int y = startY;

            queue.add(new Point(x, y));
            visit[y][x] = true;

            Point current;

            while (!queue.isEmpty()) {
                current = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int nextX = current.x + dirX[i];
                    int nextY = current.y + dirY[i];

                    if (nextX >= 0 && nextY >= 0 && nextX < m && nextY < n && !visit[nextY][nextX] && Map[nextY][nextX] == 1) {
                        queue.add(new Point(nextX, nextY));
                        visit[nextY][nextX] = true;
                        result[nextY][nextX] = result[current.y][current.x] + 1;
                    }
                }
            }
        }

        public void getResult() {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (visit[i][j] && Map[i][j] == 1) {
                        System.out.print(result[i][j] + " ");
                    } else if (!visit[i][j] && Map[i][j] == 1) {
                        System.out.print(-1 + " ");
                    } else {
                        System.out.print(0 + " ");
                    }
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Graph graph = new Graph();
    }
}
