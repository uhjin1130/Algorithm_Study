import java.io.*;
import java.util.*;

public class Main {
    public static List<Integer> list = new ArrayList<>();
    public static int[] cntFruit = new int[10];
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        System.out.println(solve(0, 0, 0, 0, 0));
    }

    public static int solve(int left, int right, int cnt, int kind, int max) {
        if (right == n)
            return max;

        if (cntFruit[list.get(right)] == 0)
            kind++;

        cntFruit[list.get(right)]++;
        cnt++;

        if (kind > 2) {
            cntFruit[list.get(left)]--;
            cnt--;
            if (cntFruit[list.get(left)] == 0) {
                kind--;
            }
            left++;
        }
        max = Math.max(cnt, max);
        return solve(left, right + 1, cnt, kind, max);
    }
}
