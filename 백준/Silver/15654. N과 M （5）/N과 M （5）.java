import java.io.*;
import java.util.*;

public class Main {

    public static int arr[], N, M;
    public static ArrayList<Integer> check = new ArrayList<>();
    public static boolean[] visited;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        dfs(0);

        System.out.println(sb.toString());

    }

    public static void dfs(int depth){
        if(depth == M){
            for(int i : check)
                sb.append(i + " ");
            sb.append("\n");
            return;
        }

        for(int i = 0; i < N; i++) {
            if(!visited[i]){
                visited[i] = true;
                check.add(arr[i]);
                dfs(depth+1);
                check.remove(check.size()-1);
                visited[i] = false;
            }
        }
    }


}