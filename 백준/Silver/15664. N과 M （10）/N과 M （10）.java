import java.io.*;
import java.util.*;

public class Main {

    public static int N, M;
    public static int[] arr, printArr;
    public static boolean[] visited;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        printArr = new int[M];
        arr = new int[N];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        dfs(0,0);

        System.out.println(sb.toString());
    }

    public static void dfs(int cur, int depth){
        if(depth == M){
            for(int i : printArr)
                sb.append(i + " ");
            sb.append("\n");
            return;
        }

        int last = -1;

        for(int i = cur; i < N; i++){
            if(!visited[i] && last != arr[i]){
                visited[i] = true;
                printArr[depth] = arr[i];
                last = arr[i];
                dfs(i+1,depth + 1);
                visited[i] = false;
            }
        }
    }
}