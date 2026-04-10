import java.util.*;
import java.io.*;

public class Main {
    public static int k;
    public static int[] lotto;
    public static int[] printArr;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while ((line = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line);
            k = Integer.parseInt(st.nextToken());

            if (k == 0)
                break;

            lotto = new int[k];
            printArr = new int[6];

            for (int i = 0; i < k; i++) {
                lotto[i] = Integer.parseInt(st.nextToken());
            }
            dfs(0, 0);
            sb.append("\n");
        }
        System.out.print(sb);

    }

    public static void dfs(int start, int depth) {
        if (depth == 6) {
            for (int i : printArr)
                sb.append(i + " ");
            sb.append("\n");
            return;
        }

        for (int i = start; i < k; i++) {
            printArr[depth] = lotto[i];
            dfs(i + 1, depth + 1);
        }
    }
}
