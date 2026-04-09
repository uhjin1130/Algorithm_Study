import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private int N; // 세로
    private int M; // 가로
    private int inven; // 인벤토리
    private int[][] land; // 땅의 높이
    private int maxHeight = 0;
    private int minHeight = 256;
    private int resultHeight = 0;
    private int totalTime = 99999999;

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    public Main() throws IOException {
        N = Integer.parseInt(st.nextToken());
        if (N > 500 || N < 1) {
            System.out.println("유효하지 않은 N 값입니다.");
            return;
        }

        M = Integer.parseInt(st.nextToken());
        if (M > 500 || M < 1) {
            System.out.println("유효하지 않은 M 값입니다.");
            return;
        }

        inven = Integer.parseInt(st.nextToken());
        if (inven < 0) {
            System.out.println("유효하지 않은 인벤토리 값입니다.");
            return;
        }

        setHeight();
        findResult();

        System.out.print(totalTime + " " + resultHeight);

        br.close();
    }

    public void setHeight() throws IOException {
        land = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                land[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, land[i][j]);
                minHeight = Math.min(minHeight, land[i][j]);
            }
        }
    }

    private void findResult() {
        for (int i = minHeight; i <= maxHeight; i++) {
            int timer = 0;
            int block = inven;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (land[j][k] > i) {
                        timer += ((land[j][k] - i) * 2);
                        block += (land[j][k] - i);
                    } else {
                        timer += (i - land[j][k]);
                        block -= (i - land[j][k]);
                    }
                }
            }

            if (block < 0)
                continue;

            if (totalTime >= timer) {
                totalTime = timer;
                resultHeight = i;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new Main();
    }
}
