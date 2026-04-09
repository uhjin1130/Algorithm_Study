import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int getNum = 0;

        for (int i = 0; i < n; i++) {
            int[] cntNum = new int[1001];
            Arrays.fill(cntNum, 0);
            int howMany = Integer.parseInt(br.readLine());

            while (howMany-- > 0)
                cntNum[Integer.parseInt(br.readLine())]++;

            int max = 0;
            int maxindex = 0;

            for (int k = 0; k < 1001; k++) {
                if (cntNum[k] > max) {
                    max = cntNum[k];
                    maxindex = k;
                }
            }

            System.out.println(maxindex);
        }
    }
}
