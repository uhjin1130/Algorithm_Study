import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        String[][] scoreBoard = new String[N][4];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            scoreBoard[i][0] = st.nextToken();
            scoreBoard[i][1] = st.nextToken();
            scoreBoard[i][2] = st.nextToken();
            scoreBoard[i][3] = st.nextToken();
        }

        Arrays.sort(scoreBoard, new Comparator<String[]>() {
            public int compare(String[] o1, String[] o2) {
                if (o1[1].equals(o2[1])) {
                    if (o1[2].equals(o2[2])) {
                        if (o1[3].equals(o2[3])) {
                            return o1[0].compareTo(o2[0]);
                        }
                        return Integer.parseInt(o2[3]) - Integer.parseInt(o1[3]);
                    }
                    return Integer.parseInt(o1[2]) - Integer.parseInt(o2[2]);
                }
                return Integer.parseInt(o2[1]) - Integer.parseInt(o1[1]);
            }
        });

        for (int i = 0; i < N; i++) {
            System.out.println(scoreBoard[i][0]);
        }
    }
}
