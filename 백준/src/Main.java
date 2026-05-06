import java.io.*;
import java.util.*;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static int N;
    public static int[][] img;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        img = new int[N][N];

        for (int i = 0; i < N; i++) {
            char[] row = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                img[i][j] = row[j] - '0';
            }
        }

        quadTree(0, 0, N);

        System.out.println(sb.toString());
    } // main

    public static void quadTree(int x, int y, int size) {
        if (check(x, y, size)) {
            sb.append(img[y][x]);
            return;
        } else {
            sb.append("(");
            int newSize = size / 2;
            quadTree(x, y, newSize);
            quadTree(x + newSize, y, newSize);
            quadTree(x, y + newSize, newSize);
            quadTree(x + newSize, y + newSize, newSize);
            sb.append(")");
        }
    }

    public static boolean check(int x, int y, int size) {
        int stand = img[y][x];

        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (img[i][j] != stand)
                    return false;
            }
        }

        return true;
    }

} // class