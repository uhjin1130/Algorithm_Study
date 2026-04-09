package boj_10819;

import java.io.*;
import java.util.*;

public class Main {
    public static int N, result;
    public static int[] A, cal;
    public static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        A = new int[N];
        visited = new boolean[N];
        cal = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        result = Integer.MIN_VALUE;
        dfs(0);

        System.out.println(result);

    }

    public static void dfs(int depth){
        if(depth == N){
            int sum = 0;
            for(int i = 0; i < N - 1; i++){
                sum += Math.abs(cal[i] - cal[i+1]);
            }
            result = Math.max(result, sum);
            return;
        }

        for(int i = 0; i < N; i++){
            if(!visited[i]) {
                visited[i] = true;
                cal[depth] = A[i];
                dfs(depth+1);
                visited[i] = false;
            }
        }
    }
}
