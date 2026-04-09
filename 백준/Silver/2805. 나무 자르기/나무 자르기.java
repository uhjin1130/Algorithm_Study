import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.Arrays;

public class Main { // 클래스 이름이 파일 이름과 일치해야 함
    public static void main(String[] args) throws IOException {
        int N = 0, M = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // Read the first line to get N and M
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // Read the second line to get the heights
        s = br.readLine();
        String[] heights = s.split(" ");

        // Convert heights from String array to int array
        int[] heightsInt = new int[N];
        for (int i = 0; i < N; i++) {
            heightsInt[i] = Integer.parseInt(heights[i]);
        }

        // Binary search setup
        int left = 0;
        int right = Arrays.stream(heightsInt).max().orElse(0); // Find the max height
        int result = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            long total = 0; // Use long to avoid overflow

            for (int height : heightsInt) {
                if (height > mid) {
                    total += height - mid;
                }
            }

            if (total >= M) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        bw.write(result + "\n");
        bw.flush();
    }
}
