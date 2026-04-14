import java.io.*;
import java.util.*;

public class Main {

    public static int N, result;
    public static int[][] S;
    public static boolean[] selected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        S = new int[N][N];
        selected = new boolean[N];
        result = Integer.MAX_VALUE;

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        back(0, 0);
        System.out.println(result);
    }

    public static void back(int idx, int cnt) {
        if(cnt == N / 2){
            calc();
            return;
        }
        if(idx == N){
            return;
        }

        selected[idx] = true;
        back(idx + 1, cnt + 1);

        selected[idx] = false;
        back(idx + 1, cnt);
        
    }

    public static void calc(){
        int start = 0, link = 0;
        for(int i = 0; i < N; i++){
            for(int j = i + 1; j < N; j++){
                if(selected[i] && selected[j])
                    start += S[i][j] + S[j][i];
                if(!selected[i] && !selected[j])
                    link += S[i][j] + S[j][i];
            }
        }
        result = Math.min(result, Math.abs(start - link));
    }
}