import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        if (n == k) {
            System.out.println(0);
            return;
        }

        int cnt = 0;
        Queue<Integer> find = new LinkedList<>();
        boolean[] check = new boolean[100001];

        find.add(n);
        check[n] = true;

        while (!find.isEmpty()) {
            int size = find.size();
            cnt++;
            for (int i = 0; i < size; i++) {
                int x = find.remove();

                if (x - 1 == k || x + 1 == k || x * 2 == k) {
                    System.out.println(cnt);
                    return;
                }

                if (x - 1 >= 0 && !check[x - 1]) {
                    check[x - 1] = true;
                    find.add(x - 1);
                }
                if (x + 1 <= 100000 && !check[x + 1]) {
                    check[x + 1] = true;
                    find.add(x + 1);
                }
                if (x * 2 <= 100000 && !check[x * 2]) {
                    check[x * 2] = true;
                    find.add(x * 2);
                }
            }
        }
    }
}
