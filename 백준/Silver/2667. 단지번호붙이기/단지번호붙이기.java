import java.io.*;
import java.util.*;

public class Main{
    static int n;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int count = 1;
    static List<Integer> danji = new LinkedList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        map = new int[n][n];
        visited = new boolean[n][n];
        
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            for(int j =0; j < n; j++){
                map[i][j] = a.charAt(j) - '0';
            }
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(map[i][j] == 1 && !visited[i][j]){
                    dfs(i, j);
                    danji.add(count);
                    count = 1;
                }
            }
        }
        
        Collections.sort(danji);
        
        System.out.println(danji.size());
        for(int r : danji) {
            System.out.println(r);
        }
        
    }
    
    public static void dfs(int x, int y) {
        visited[x][y] = true;
        
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny] && map[nx][ny] == 1){
                count++;
                dfs(nx, ny);
            }
        }
    }
}