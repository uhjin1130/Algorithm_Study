import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static int result = Integer.MAX_VALUE;
    public static ArrayList<int[]> taste = new ArrayList<>();
    public static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        visited = new boolean[N];
        StringTokenizer st;
        int sour, bitter;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            sour = Integer.parseInt(st.nextToken());
            bitter = Integer.parseInt(st.nextToken());

            taste.add(new int[] { sour, bitter });
        }

        tasteCheck(0);

        System.out.println(result);

    } // main

    public static void tasteCheck(int idx) {
        if (idx >= N) {
            int sour = 1;
            int bitter = 0;
            boolean isZero = true;

            for (int i = 0; i < N; i++) {
                if (visited[i]) {
                    sour *= taste.get(i)[0];
                    bitter += taste.get(i)[1];
                    isZero = false;
                }
            }

            if (!isZero) {
                int sum = Math.abs(sour - bitter);
                result = Math.min(result, sum);
            }

            return;
        }

        visited[idx] = true;
        tasteCheck(idx + 1);

        visited[idx] = false;
        tasteCheck(idx + 1);
    }

} // class