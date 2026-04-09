import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int cnt = 0;
        int criteria = 10;
        int num = 1;

        for (int i = 1; i <= N; i++) {
            if (i % criteria == 0) {
                num += 1;
                criteria *= 10;
            }
            cnt += num;
        }

        System.out.println(cnt);

    }

}