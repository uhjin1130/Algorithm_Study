import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] scoreBoard = new int[N];

        StringTokenizer st;

        int maxScore = 0;
        int score = 0;
        int a, d, g = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());

            if (a != (d + g)) {
                score = a * (d + g);
                if (score > maxScore) {
                    maxScore = score;
                }
            } else {
                score = 2 * (a * (d + g));
                if (score > maxScore) {
                    maxScore = score;
                }
            }
        }

        System.out.println(maxScore);

    }
}
