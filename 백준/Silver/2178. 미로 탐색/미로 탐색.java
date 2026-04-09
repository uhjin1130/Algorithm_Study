import java.util.*;
import java.io.*;
import java.awt.*;


public class Main{
    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0 ; i < n; i++){
            String s = br.readLine();
            for(int j = 0 ; j < m; j++){
                map[i][j] = s.charAt(j) - '0';
            }
        }

        bfs(0, 0);
        System.out.println(map[n-1][m-1]);
    }

    public static void bfs(int x, int y){
        Queue<Point> q = new LinkedList<>();
        visited[x][y] = true;
        q.add(new Point(x, y));

        while(!q.isEmpty()){
            Point cur = q.poll();
            for(int i = 0 ; i < 4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(0<=nx && nx<n && 0<=ny && ny<m && !visited[nx][ny] && map[nx][ny]>0){
                    q.add(new Point(nx, ny));
                    visited[nx][ny] = true;
                    map[nx][ny] = map[cur.x][cur.y] + 1;
                }
            }
        }
    }
}