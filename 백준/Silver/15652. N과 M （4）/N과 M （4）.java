import java.io.*;
import java.util.*;

public class Main {

    public static int arr[], N, M;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        dfs(1,0);

        System.out.println(sb.toString());

    }

    public static void dfs(int cur, int depth) {
        if(depth == M){
            for(int i : arr)
                sb.append(i + " ");
            sb.append("\n");
            return;
        }

        for(int i = cur; i <= N; i++){
            arr[depth] = i;
            dfs(i,depth + 1);
        }
    }


}