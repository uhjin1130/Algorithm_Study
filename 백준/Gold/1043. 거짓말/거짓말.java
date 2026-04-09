import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static List<Integer> knowList;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parents = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int knowPerson = Integer.parseInt(st.nextToken());
        knowList = new ArrayList<>();
        if (knowPerson == 0) {
            System.out.println(m);
            return;
        } else {
            for (int i = 0; i < knowPerson; i++) {
                knowList.add(Integer.parseInt(st.nextToken()));
            }
        }

        List<Integer>[] party = new ArrayList[m];
        for (int i = 0; i < m; i++) {
            party[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int person = Integer.parseInt(st.nextToken());

            int x = Integer.parseInt(st.nextToken());
            party[i].add(x);
            for (int j = 1; j < person; j++) {
                int y = Integer.parseInt(st.nextToken());
                union(x, y);
                party[i].add(y);
            }
        }

        int cnt = 0;
        for (int i = 0; i < m; i++) {
            boolean flag = true;
            for (int num : party[i]) {
                if (knowList.contains(find(parents[num]))) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    public static int find(int x) {
        if (parents[x] == x)
            return x;
        return find(parents[x]);
    }

    public static void union(int x, int y) {
        int rx = find(x);
        int ry = find(y);

        if (knowList.contains(ry)) {
            int tmp = rx;
            rx = ry;
            ry = tmp;
        }

        parents[ry] = rx;
    }

}
