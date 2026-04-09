import java.io.*;
import java.util.*;

public class Main {
    public static int MAX = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        long count5 = count(n, 5) - count(m, 5) - count(n-m, 5);
        long count2 = count(n, 2) - count(m, 2) - count(n-m, 2);

        System.out.println(Math.min(count5, count2));

    }

    public static long count(long n, long p){
        long count = 0;
        while(n>=p){
            count += n / p;
            n /= p;
        }
        return count;
    }

}