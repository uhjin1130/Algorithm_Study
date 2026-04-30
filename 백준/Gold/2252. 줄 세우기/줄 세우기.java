import java.io.*;
import java.util.*;

public class Main {

    static int N, M; // N : 노드의 수. M : 간선의 수.
    static int inDegree[]; // 진입차수 - inDegree[3]==2; -> 3번 노드로 들어오는 간선이 2개
    static List<Integer>[] graph; // g[1]==3; --> 1번 노드의 뒤의 노드 목록 // 인접리스트

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        inDegree = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph[A].add(B);
            inDegree[B]++;
        }

        topologySort();

    } // main

    static void topologySort() {
        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0)
                queue.offer(i);
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            sb.append(cur).append(" ");
            for (int next : graph[cur]) {
                inDegree[next]--;
                if (inDegree[next] == 0)
                    queue.offer(next);
            }
        }

        System.out.println(sb.toString());
    } // topologySort

} // class