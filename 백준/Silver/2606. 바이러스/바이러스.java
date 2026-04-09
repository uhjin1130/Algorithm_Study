import java.util.*;
import java.io.*;

public class Main{
    static int n, m;
    static boolean[] check;
    static int[][] arr;
    static int cnt = 0;
    
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        check = new boolean[n+1];
        arr = new int[n+1][n+1];

        for(int i = 0; i < m; i++){
            StringTokenizer str = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());

            arr[a][b] = arr[b][a] = 1;
        }

        bfs(1);

        System.out.println(cnt);
    }
    
    public static void bfs(int start){
        check[start] = true;
        q.add(start);
        
        while(!q.isEmpty()){
            int cur = q.poll();
            
            for(int i = 1; i <= n; i++) {
                if(arr[cur][i] == 1 && !check[i]){
                    q.add(i);
                    cnt++;
                    check[i] = true;
                }
            }
        }
        
    }

    
}