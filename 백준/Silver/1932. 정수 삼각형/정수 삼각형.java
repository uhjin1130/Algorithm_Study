import java.io.*;
import java.util.*;

public class Main{

    public static int[][] triangle;
    public static int[][] result;
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        triangle = new int[n][n];
        result = new int[n][n];

        for(int i = 0 ; i < n; i++){
            for(int j = 0 ; j < n ; j++){
                result[i][j] = -1;
            }
        }

        for(int i = 0 ; i < n ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j <= i ; j++){
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < n; i++){
            result[n-1][i] = triangle[n-1][i];
        }

        System.out.println(find(0,0));

    }

    public static int find(int depth, int idx){
        if(depth == n-1)
            return result[depth][idx];

        if(result[depth][idx] == -1){
            result[depth][idx] = Math.max(find(depth+1, idx), find(depth+1, idx+1)) + triangle[depth][idx];
        }

        return result[depth][idx];
    }


}