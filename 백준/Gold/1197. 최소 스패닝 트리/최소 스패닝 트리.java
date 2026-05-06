import java.io.*;
import java.util.*;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static int N, E;
    public static int[][] graph;
    public static int[] nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        nodes = new int[N + 1];
        graph = new int[E + 1][3];

        for (int i = 0; i <= N; i++) {
            nodes[i] = i;
        }

        for (int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[i][0] = from;
            graph[i][1] = to;
            graph[i][2] = weight;
        }

        Arrays.sort(graph, 1, E + 1, (o1, o2) -> Integer.compare(o1[2], o2[2]));

        kruskal();

    } // main

    public static void kruskal() {
        int cost = 0;
        int cnt = 0;
        for (int i = 1; i <= E; i++) {
            if (find(graph[i][0]) != find(graph[i][1])) {
                union(graph[i][0], graph[i][1]);
                cnt++;
                cost += graph[i][2];

                if (cnt == N - 1)
                    break;
            }
        }

        System.out.println(cost);
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a < b)
            nodes[b] = a;
        else
            nodes[a] = b;
    }

    public static int find(int x) {
        if (nodes[x] == x)
            return x;
        else
            return find(nodes[x]);
    }

} // class