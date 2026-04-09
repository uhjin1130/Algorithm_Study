import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        int[] inCdp = new int[N + 1];
        int[] deCdp = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            inCdp[i] = 1;
            deCdp[i] = 1;
        }


        for (int i = 1; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                if (arr[i] > arr[j]) {
                    inCdp[i] = Math.max(inCdp[i], inCdp[j] + 1);
                }
            }
        }

        for (int i = N; i >= 1; i--) {
            for (int j = N; j > i; j--) {
                if (arr[i] > arr[j]) {
                    deCdp[i] = Math.max(deCdp[i], deCdp[j] + 1);
                }
            }
        }

        int result = 0;

        for(int i = 1; i <= N; i++){
            result = Math.max(result, inCdp[i] + deCdp[i] - 1);
        }

        System.out.println(result);

    }
}