import java.io.*;
import java.util.*;

public class Main {
    public static int L, C;
    public static String[] pw, tryPw;
    public static String moeum = "aeiou";
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        pw = new String[C];
        tryPw = new String[L];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            pw[i] = st.nextToken();
        }
        Arrays.sort(pw);
        dfs(0, 0, 0, 0);

        System.out.println(sb.toString());
    }

    public static void dfs(int cur, int depth, int mo, int ja) {
        if (depth == L) {
            if (mo >= 1 && ja >= 2) {
                for (String i : tryPw)
                    sb.append(i);
                sb.append("\n");
            }
            return;
        }

        for (int i = cur; i < C; i++) {
            tryPw[depth] = pw[i];
            if (moeum.contains(pw[i])) {
                dfs(i + 1, depth + 1, mo + 1, ja);
            } else {
                dfs(i + 1, depth + 1, mo, ja + 1);
            }
        }
    }
}
