import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int n, m;
    public static final int INF = 999999999;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n+1][n+1];

        for(int i = 1; i <= n; i++){
            for(int j = 1; j<= n; j++){
                arr[i][j] = INF;
                if (i == j) {
                    arr[i][j] = 0;
                }
            }
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x][y] = arr[y][x] = 1;
        }

        // 경유지
        for (int k = 1; k <= n; k++) {
            // 출발지
            for (int i = 1; i <= n; i++) {
                // 도착지
                for (int j = 1; j <= n; j++) {
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }

        int res = INF;
        int bacon = -1;

        for(int i = 1; i <= n; i++){
            int total = 0;
            for(int j = 1; j <=n; j++){
                total += arr[i][j];
            }
            if(res > total){
                res = total;
                bacon = i;
            }
        }

        bw.write(bacon + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}