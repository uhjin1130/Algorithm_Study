import java.io.*;
import java.util.*;

public class Main {
    public static int N, M;
    public static int[][] map;
    public static boolean[] visited;
    public static ArrayList<int[]> chicken = new ArrayList<>();
    public static ArrayList<int[]> home = new ArrayList<>();
    public static ArrayList<int[]> myChicken = new ArrayList<>();
    public static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1)
                    home.add(new int[] { i, j });
                if (map[i][j] == 2)
                    chicken.add(new int[] { i, j });
            }
        }

        visited = new boolean[chicken.size()];

        find(0, 0);

        System.out.println(result);

    } // main

    public static void find(int start, int depth) {
        if (depth == M) {
            int sum = 0;
            for (int[] i : home) {
                int min = Integer.MAX_VALUE;
                for (int[] j : myChicken) {
                    int absolute = Math.abs(i[0] - j[0]) + Math.abs(i[1] - j[1]);
                    min = Math.min(min, absolute);
                }
                sum += min;
            }
            result = Math.min(result, sum);
            return;
        }

        for (int i = start; i < chicken.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                myChicken.add(chicken.get(i));
                find(i + 1, depth + 1);
                myChicken.remove(chicken.get(i));
                visited[i] = false;
            }
        }
    }

} // class