import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String T = br.readLine();
        String P = br.readLine();

        List<Integer> result = kmpMatch(T, P);

        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append('\n');
        for (int idx : result) {
            sb.append(idx).append('\n');
        }
        System.out.print(sb);
    }

    public static List<Integer> kmpMatch(String T, String P) {
        int n = T.length(), m = P.length();
        List<Integer> result = new ArrayList<>();

        // skip 테이블 구성 (pt = text 포인터, pp = pattern 포인터)
        int[] skip = new int[m];
        int pp = 0;
        for (int pt = 1; pt < m; pt++) {
            while (pp > 0 && P.charAt(pt) != P.charAt(pp))
                pp = skip[pp - 1];
            if (P.charAt(pt) == P.charAt(pp))
                skip[pt] = ++pp;
        }

        // KMP 매칭 (pt = text 포인터, pp = pattern 포인터)
        pp = 0;
        for (int pt = 0; pt < n; pt++) {
            while (pp > 0 && T.charAt(pt) != P.charAt(pp))
                pp = skip[pp - 1];
            if (T.charAt(pt) == P.charAt(pp))
                pp++;
            if (pp == m) {
                result.add(pt - m + 2); // 1-based 인덱스
                pp = skip[pp - 1]; // 매칭 후 계속 탐색
            }
        }

        return result;
    }
}