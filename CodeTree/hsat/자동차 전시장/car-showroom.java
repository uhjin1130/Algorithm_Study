import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 노드
        int m = sc.nextInt(); // 간선
        int k = sc.nextInt(); // 사람 수
        int[][] edges = new int[m][2];
        for (int i = 0; i < m; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
        }
        int[] startPoints = new int[k];
        for (int i = 0; i < k; i++) {
            startPoints[i] = sc.nextInt();
        }
        // Please write your code here.
        ArrayList<Integer>[] graph = new ArrayList[n + 1]; // 인접 리스트
        for(int i = 1; i <= n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            graph[u].add(v);
        }

        int[] maxTime = new int[n + 1]; // x까지 가는 데 걸린 시간 중 최대
        int[] reachCount = new int[n + 1]; // 도달한 사람 수

        for(int start : startPoints) {
            int[] dist = bfs(graph, start, n);
            for(int x = 1; x <= n; x++){
                if(dist[x] != -1) {
                    reachCount[x]++;
                    maxTime[x] = Math.max(maxTime[x], dist[x]);
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for(int x = 1; x <= n; x++){
            if(reachCount[x] == k)
                result = Math.min(result, maxTime[x]);
        }
        if(result == Integer.MAX_VALUE)
            System.out.print(-1);
        else
            System.out.print(result);
        
    }

    public static int[] bfs(ArrayList<Integer>[] graph, int start, int n){
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        Queue<Integer> queue = new LinkedList<>();
        
        dist[start] = 0;
        queue.add(start);

        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int next : graph[cur]) {
                if(dist[next] == -1) {
                    dist[next] = dist[cur] + 1;
                    queue.add(next);
                }
            }
        }

        return dist;
    }
}
