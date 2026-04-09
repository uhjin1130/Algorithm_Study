import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] num = new int[m+1];

        for(int i = 0; i <= m; i++){
            num[i] = 0;
        }

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            int num1 = Integer.parseInt(st1.nextToken());
            num[num1]++;
        }
        int max = -1;
        for(int i = 1; i <= m; i++){
            max = Math.max(max, num[i]);
        }
        System.out.println(max);

    }

}