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
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);

        int N = Integer.parseInt(st.nextToken());
        int haveCard[] = new int[N];

        s = br.readLine();
        st = new StringTokenizer(s);

        for (int i = 0; i < N; i++) {
            haveCard[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(haveCard);

        s = br.readLine();
        int M = Integer.parseInt(s);

        s = br.readLine();
        st = new StringTokenizer(s);

        int num;

        for (int i = 0; i < M; i++) {
            num = Integer.parseInt(st.nextToken());

            if (binarySearch(haveCard, num)) {
                bw.write("1 ");
            } else {
                bw.write("0 ");
            }
        }

        bw.flush();
        bw.close();
    }

    public static boolean binarySearch(int array[], int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int middle = (left + right) / 2;
            if (array[middle] == target) {
                return true;
            } else if (array[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return false;
    }
}
