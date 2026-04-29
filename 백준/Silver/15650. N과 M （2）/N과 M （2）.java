import java.io.*;
import java.util.*;

public class Main {

    public static int arr[];
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        dfs(N, M, 1, 0);
        System.out.println(sb.toString());

    }

    public static void dfs(int N, int M, int cur, int depth){
        if(depth == M){
            for(int i : arr){
                sb.append(i + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i = cur; i <= N; i++){
            arr[depth] = i;
            dfs(N, M, i + 1, depth+1);
        }
    }


}