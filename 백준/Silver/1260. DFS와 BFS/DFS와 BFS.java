import java.io.*;
import java.util.*;

public class Main {
    public static int n, m, v;
    public static int[][] arr;
    public static boolean[] visit;
    public static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        
        arr = new int[n+1][n+1];
        visit = new boolean[n+1];

        for(int i = 0; i < m; i++){
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st1.nextToken());
            int b = Integer.parseInt(st1.nextToken());
            arr[a][b] = arr[b][a] = 1;
        }
        
        dfs(v);
        sb.append("\n");
        visit = new boolean[n+1];
        
        bfs(v);
        
        System.out.print(sb);
        
    }
    
    public static void dfs(int start){
        visit[start] = true;
        sb.append(start+" ");
        
        for(int i = 0; i <= n; i++){
            if(!visit[i] && arr[start][i] == 1){
                dfs(i);
            }
        }
    }

    public static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        visit[start] = true;
        queue.add(start);
        
        while(!queue.isEmpty()){
            start = queue.poll();
            sb.append(start + " ");
            for(int i = 0; i <= n; i++){
                if(!visit[i] && arr[start][i] == 1){
                    queue.add(i);
                    visit[i] = true;
                }
            }
        }
    }

}