import java.util.*;
import java.io.*;

class Node {
    int toNode;
    int weight;

    public Node(int end, int weight) {
        this.toNode = end;
        this.weight = weight;
    }
}

public class Main {
    public static int V, E, K;
    public static ArrayList<Node>[] graph;
    public static int[] result;
    public static boolean[] visitied;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        graph = new ArrayList[V + 1];
        result = new int[V + 1];
        visitied = new boolean[V + 1];

        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
            result[i] = Integer.MAX_VALUE;
        }

        int start, end, weight;
        for (int i = 1; i <= E; i++) {
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
        queue.offer(new Node(K, 0));

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if (result[cur.toNode] < cur.weight)
                continue;

            for (Node node : graph[cur.toNode]) {
                if (cur.weight + node.weight < result[node.toNode]) {
                    result[node.toNode] = cur.weight + node.weight;
                    queue.offer(new Node(node.toNode, result[node.toNode]));
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