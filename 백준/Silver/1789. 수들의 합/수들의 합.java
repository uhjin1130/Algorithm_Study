import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());

        int minus = 1;

        while (true) {
            if (N >= minus) {
                N -= minus;
                minus++;
            } else {
                break;
            }
        }

        System.out.println(--minus);
    }
}
