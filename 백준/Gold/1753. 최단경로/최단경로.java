import java.util.*;
import java.io.*;

class Node {
    int to;
    int weight;

    public Node(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}

public class Main {
    public static int V, E, K;
    public static StringBuilder sb = new StringBuilder();
    public static ArrayList<Node>[] graph;
    public static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        graph = new ArrayList[V + 1];
        result = new int[V + 1];

        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
            result[i] = Integer.MAX_VALUE;
        }

        int start, end, weight;
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            weight = Integer.parseInt(st.nextToken());

            graph[start].add(new Node(end, weight));
        }

        dikjstra();
        System.out.println(sb.toString());

    }

    public static void dikjstra() {
        PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        result[K] = 0;
        queue.add(new Node(K, 0));

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if (result[cur.to] < cur.weight)
                continue;

            for (Node node : graph[cur.to]) {
                if (cur.weight + node.weight < result[node.to]) {
                    result[node.to] = cur.weight + node.weight;
                    queue.add(new Node(node.to, result[node.to]));
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            if (result[i] == Integer.MAX_VALUE)
                sb.append("INF").append("\n");
            else
                sb.append(result[i]).append("\n");
        }
    }

}