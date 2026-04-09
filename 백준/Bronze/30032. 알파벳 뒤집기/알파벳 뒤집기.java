import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        String[][] arr = new String[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String getWord = st.nextToken();
            arr[i] = getWord.split("");
        }

        for (int cnt = 0; cnt < N; cnt++) {
            for (int i = 0; i < N; i++) {
                String ch = arr[cnt][i];
                if (D == 1) {
                    switch (ch) {
                        case "d":
                            System.out.print("q");
                            break;
                        case "b":
                            System.out.print("p");
                            break;
                        case "q":
                            System.out.print("d");
                            break;
                        case "p":
                            System.out.print("b");
                            break;
                        default:
                            System.out.print(ch);
                    }
                } else {
                    switch (ch) {
                        case "d":
                            System.out.print("b");
                            break;
                        case "b":
                            System.out.print("d");
                            break;
                        case "q":
                            System.out.print("p");
                            break;
                        case "p":
                            System.out.print("q");
                            break;
                        default:
                            System.out.print(ch);
                    }
                }
            }
            System.out.println();
        }
    }
}
