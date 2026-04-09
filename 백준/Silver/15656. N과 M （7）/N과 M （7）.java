import java.io.*;
import java.util.*;

public class Main {

    public static int N, M;
    public static int[] arr, printArr;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        printArr = new int[M];
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        dfs(0);

        System.out.println(sb.toString());
    }

    public static void dfs(int depth){
        if(depth == M){
            for(int i : printArr)
                sb.append(i + " ");
            sb.append("\n");
            return;
        }

        for(int i = 0; i < N; i++){
            printArr[depth] = arr[i];
            dfs(depth+1);
        }
    }
}