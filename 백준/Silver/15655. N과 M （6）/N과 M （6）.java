import java.io.*;
import java.util.*;

public class Main {

    public static int N, M;
    public static int[] arr, selected;
    public static StringBuilder sb = new StringBuilder();
    public static boolean[] visit;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        selected = new int[M];
        visit = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        dfs(0, 0);

        System.out.println(sb.toString());

    }

    public static void dfs(int cur, int depth){
        if(depth == M){
            for(int i : selected)
                sb.append(i + " ");
            sb.append("\n");
            return;
        }

        for(int i = cur; i < N; i++){
            if(!visit[i]){
                visit[i] = true;
                selected[depth] = arr[i];
                dfs(i + 1, depth + 1);
                visit[i] = false;
            }
        }
    }
}