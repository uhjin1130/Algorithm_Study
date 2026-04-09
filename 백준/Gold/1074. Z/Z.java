import java.io.*;
import java.util.*;

public class Main {
    static public int n, r, c, count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int size = (int) Math.pow(2, n);

        find(size, r, c);
    }

    public static void find(int size, int r, int c) {
        if (size == 1) {
            System.out.println(count);
            return;
        }
        if (r < size / 2 && c < size / 2) {
            find(size / 2, r, c);
        } else if (r < size / 2 && c >= size / 2) {
            count += size * size / 4;
            find(size / 2, r, c - (size / 2));
        } else if (r >= size / 2 && c < size / 2) {
            count += size * size / 4 * 2;
            find(size / 2, r - (size / 2), c);
        } else if (r >= size / 2 && c >= size / 2) {
            count += size * size / 4 * 3;
            find(size / 2, r - (size / 2), c - (size / 2));
        }
    }
}
