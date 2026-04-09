import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        char[] chars = br.readLine().toCharArray();

        int result = 0;
        int ioiCnt = 0;
        int i = 0;

        while (i < M - 2) {
            if (chars[i] == 'I' && chars[i + 1] == 'O' && chars[i + 2] == 'I') {
                ioiCnt++;
                if (ioiCnt >= N) {
                    result++;
                }
                i += 2;
            } else {
                ioiCnt = 0;
                i++;
            }
        }
        
        System.out.println(result);

    }
}