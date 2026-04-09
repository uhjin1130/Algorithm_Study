import java.util.*;
import java.io.*;

public class Main{
    static int n,k;
    static int[] check;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        check = new int[100001];
        Arrays.fill(check, -1);
        bfs();
        System.out.print(result);
    }
    public static void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        check[n] = 0;
        queue.add(n);
        
        while(!queue.isEmpty()){
            int cur = queue.poll();
            if(cur==k){
                result = check[cur];
                return;
            }
            int[] nxt = {cur-1,cur+1,cur*2};
            for(int i : nxt){
                if(i>=0 && i<=100000 && check[i] == -1){
                    check[i] = check[cur] + 1;
                    queue.add(i);
                }
            }
        }
    }
}