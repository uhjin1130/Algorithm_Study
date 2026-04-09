import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = br.readLine().split("-");
        int sum = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            int temp = 0;
            String[] subarr = arr[i].split("\\+");
            for (int j = 0; j < subarr.length; j++) {
                temp += Integer.parseInt(subarr[j]);
            }
            if (sum == Integer.MAX_VALUE) {
                sum = temp;
            } else {
                sum -= temp;
            }
        }

        System.out.println(sum);
    }
}
