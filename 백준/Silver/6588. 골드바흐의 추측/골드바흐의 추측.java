import java.io.*;
import java.util.*;

public class Main {
    public static int MAX = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Boolean[] isPrime = new Boolean[MAX + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i <= MAX; i++) {
            for (int j = i * 2; j <= MAX; j += i) {
                if (!isPrime[j])
                    continue;
                isPrime[j] = false;
            }
        }

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            boolean pass = false;

            for (int i = 2; i <= n / 2; i++) {
                if (isPrime[i] && isPrime[n - i]) {
                    System.out.println(n + " = " + i + " + " + (n - i));
                    pass = true;
                    break;
                }
            }
            if (!pass)
                System.out.println("Goldbach's conjecture is wrong.");

        }

    }

}