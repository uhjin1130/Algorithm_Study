import java.io.*;
import java.util.*;

public class Main {

    public static int N;
    public static int[] arr, op;
    public static int max = Integer.MIN_VALUE;
    public static int min = Integer.MAX_VALUE;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        op = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < 4; j++) {
            op[j] = Integer.parseInt(st.nextToken());
        }

        calc(arr[0], 1);

        System.out.println(max + "\n" + min);
    }

    public static void calc(int sum, int index) {
        if (index == N) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (op[i] > 0) {
                op[i]--;

                if (i == 0)
                    calc(sum + arr[index], index + 1);
                else if (i == 1)
                    calc(sum - arr[index], index + 1);
                else if (i == 2)
                    calc(sum * arr[index], index + 1);
                else if (i == 3)
                    calc(sum / arr[index], index + 1);

                op[i]++;
            }
        }

    }

}