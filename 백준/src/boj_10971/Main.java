package boj_10971;

import java.io.*;
import java.util.*;

public class Main {
    public static int N, result = Integer.MAX_VALUE;
    public static int[][] W;
    public static int[] pay;
    public static boolean[] visited;
    public static void main(String[] args)  throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        pay = new int[N];
        W = new int[N][N];
        visited = new boolean[N];

        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, 0, 1);

        System.out.println(result);
    }

    public static void dfs(int start, int now, int cost, int depth){
        if(depth == N ){
            if(W[now][start] > 0){
                result = Math.min(result, cost+W[now][start]);
            }
            return;
        }

        for(int i = 1; i < N; i++){
            if(W[now][i] > 0 && !visited[i]){
                visited[i] = true;
                dfs(start, i, cost+W[now][i], depth+1);
                visited[i] = false;
            }
        }
    }
}
