import java.io.*;
import java.math.BigInteger;

public class Main {

    public static int N;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        BigInteger num = new BigInteger("2");
        sb.append(num.pow(N).subtract(new BigInteger("1"))).append("\n");

        if (N <= 20) {
            hanoi(N, 1, 2, 3);
        }

        System.out.println(sb.toString());

    }

    public static void hanoi(int n, int start,int mid, int end){
        if(n == 1) {
            sb.append(start + " " + end + "\n");
            return;
        }

        hanoi(n - 1, start, end, mid);
        sb.append(start + " " + end + "\n");
        hanoi(n - 1, mid, start, end);
    }

}