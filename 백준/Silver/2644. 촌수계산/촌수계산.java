import java.util.*;
import java.io.*;

public class Main{
    static int n, start, end, m;
    static List<Integer>[] relation;
    static boolean[] check;
    static int res = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());

        relation = new ArrayList[n+1];
        check = new boolean[n+1];

        for(int i = 1; i < n+1; i++){
            relation[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){
            StringTokenizer str = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());

            relation[a].add(b);
            relation[b].add(a);
        }

        dfs(start, end, 0);
        System.out.print(res);
    }

    public static void dfs(int start, int end, int count){
        if(start == end){
            res = count;
            return;
        }

        check[start] = true;

        for(int i = 0; i < relation[start].size(); i++){
            int next = relation[start].get(i);
            if(!check[next]){
                dfs(next, end, count+1);
            }
        }
    }
}