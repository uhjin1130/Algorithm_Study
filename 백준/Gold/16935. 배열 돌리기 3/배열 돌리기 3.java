import java.io.*;
import java.util.*;

public class Main {
    static int n, m, r;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < r; i++) {
            int op = Integer.parseInt(st.nextToken());

            switch (op) {
                case 1:
                    calc1();
                    break;
                case 2:
                    calc2();
                    break;
                case 3:
                    calc3();
                    break;
                case 4:
                    calc4();
                    break;
                case 5:
                    calc5();
                    break;
                case 6:
                    calc6();
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    // 1번
    static void calc1() {
        int[][] temp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                temp[i][j] = map[n - 1 - i][j];
            }
        }

        map = temp;
    }

    // 2번
    static void calc2() {
        int[][] temp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                temp[i][j] = map[i][m - 1 - j];
            }
        }

        map = temp;
    }

    // 3번
    static void calc3() {
        int[][] temp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                temp[i][j] = map[n - 1 - j][i];
            }
        }

        map = temp;

        int t = n;
        n = m;
        m = t;
    }

    // 4번
    static void calc4() {
        int[][] temp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                temp[i][j] = map[j][m - 1 - i];
            }
        }

        map = temp;

        int t = n;
        n = m;
        m = t;
    }

    // 5번
    static void calc5() {
        int[][] temp = new int[n][m];
        int hn = n / 2;
        int hm = m / 2;

        // 1 -> 2
        for (int i = 0; i < hn; i++) {
            for (int j = 0; j < hm; j++) {
                temp[i][j + hm] = map[i][j];
            }
        }

        // 2 -> 3
        for (int i = 0; i < hn; i++) {
            for (int j = hm; j < m; j++) {
                temp[i + hn][j] = map[i][j];
            }
        }

        // 3 -> 4
        for (int i = hn; i < n; i++) {
            for (int j = hm; j < m; j++) {
                temp[i][j - hm] = map[i][j];
            }
        }

        // 4 -> 1
        for (int i = hn; i < n; i++) {
            for (int j = 0; j < hm; j++) {
                temp[i - hn][j] = map[i][j];
            }
        }

        map = temp;
    }

    // 6번
    static void calc6() {
        int[][] temp = new int[n][m];
        int hn = n / 2;
        int hm = m / 2;

        // 1 -> 4
        for (int i = 0; i < hn; i++) {
            for (int j = 0; j < hm; j++) {
                temp[i + hn][j] = map[i][j];
            }
        }

        // 4 -> 3
        for (int i = hn; i < n; i++) {
            for (int j = 0; j < hm; j++) {
                temp[i][j + hm] = map[i][j];
            }
        }

        // 3 -> 2
        for (int i = hn; i < n; i++) {
            for (int j = hm; j < m; j++) {
                temp[i - hn][j] = map[i][j];
            }
        }

        // 2 -> 1
        for (int i = 0; i < hn; i++) {
            for (int j = hm; j < m; j++) {
                temp[i][j - hm] = map[i][j];
            }
        }

        map = temp;
    }
}