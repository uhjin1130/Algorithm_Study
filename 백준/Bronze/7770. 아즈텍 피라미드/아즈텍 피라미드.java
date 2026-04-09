import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int totalBlock = 1;
        int add = 1;
        int layer = 1;

        while (true) {
            add += 4 * layer;
            totalBlock += add;

            if (totalBlock > n)
                break;

            layer++;
        }

        System.out.println(layer);
    }
}
