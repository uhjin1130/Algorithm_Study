import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int result = caculate(N, 0);

        System.out.println(result);

    } // main

    public static int caculate(int x, int count) {
        if (x < 2)
            return count;

        return Math.min(caculate(x / 2, count + 1 + (x % 2)), caculate(x / 3, count + 1 + (x % 3)));
    }

} // class