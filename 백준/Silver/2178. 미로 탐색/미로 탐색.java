import java.util.*;
import java.io.*;
import java.awt.*;

public class Main{
    public static int n, m;
    public static int[][] map;
    public static boolean[][] visit;
    public static int[] dx = { 0, 0, -1, 1};
    public static int[] dy = { -1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visit = new boolean[n][m];

        for(int i = 0; i < n; i++){
            String line = br.readLine();
            for(int j = 0; j < m; j++){
                map[i][j] = line.charAt(j) - '0';
            }
        }
        
        bfs(0, 0);
        System.out.println(map[n-1][m-1]);
    }

    public static void bfs(int x, int y){
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        visit[x][y] = true;

        while(!queue.isEmpty()){
            Point cur = queue.poll();
            for(int i = 0; i < 4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx >= 0 && nx < n && ny >= 0 && ny < m && !visit[nx][ny] && map[nx][ny] > 0){
                    queue.add(new Point(nx, ny));
                    visit[nx][ny] = true;
                    map[nx][ny] = map[cur.x][cur.y] + 1;
                }
            }
        }
    }
}