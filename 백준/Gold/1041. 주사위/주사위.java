import java.io.*;
import java.util.*;

public class Main {
    public static long n, total;
    public static long[] diceNum = new long[6];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 6; i++) {
            diceNum[i] = Integer.parseInt(st.nextToken());
        }

        if (n == 1) {
            Arrays.sort(diceNum);
            for (int i = 0; i < 5; i++) {
                total += diceNum[i];
            }
            System.out.println(total);
            return;
        } else {
            find3();
            find2();
            find1();
            System.out.println(total);
            return;
        }
    }

    public static void find3() {
        int min3 = 0;
        for (int i = 0; i < 3; i++) {
            min3 += Math.min(diceNum[i], diceNum[5 - i]);
        }
        total += min3 * 4;
    }

    public static void find2() {
        long min2 = Long.MAX_VALUE;
        for (int i = 0; i < 6; i++) {
            for (int j = i + 1; j < 6; j++) {
                if (i + j != 5) {
                    min2 = Math.min(min2, diceNum[i] + diceNum[j]);
                }
            }
        }
        total += min2 * (4 * (n - 1) + 4 * (n - 2));
    }

    public static void find1() {
        long min1 = Long.MAX_VALUE;
        for (int i = 0; i < 6; i++) {
            min1 = Math.min(min1, diceNum[i]);
        }
        total += min1 * ((n - 2) * (n - 1) * 4 + (n - 2) * (n - 2));
    }
}
