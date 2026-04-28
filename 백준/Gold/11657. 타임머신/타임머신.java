import java.util.*;
import java.io.*;

class Edge {
    int start;
    int end;
    int time;

    public Edge(int start, int end, int time) {
        this.start = start;
        this.end = end;
        this.time = time;
    }
}

public class Main {
    public static int N, M, A, B, C;
    public static ArrayList<Edge> cities = new ArrayList<>();
    public static Long[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dist = new Long[N + 1];

        Arrays.fill(dist, Long.MAX_VALUE);
        dist[1] = 0L;

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            cities.add(new Edge(A, B, C));
        }

        belmanFord();

    }

    public static void belmanFord() {
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Edge cur = cities.get(j);
                if (dist[cur.start] != Long.MAX_VALUE
                        && dist[cur.end] > dist[cur.start] + cur.time)
                    dist[cur.end] = dist[cur.start] + cur.time;
            }
        }

        boolean hasNegCycle = false;
        for (int j = 0; j < M; j++) {
            Edge cur = cities.get(j);
            if (dist[cur.start] != Long.MAX_VALUE
                    && dist[cur.end] > dist[cur.start] + cur.time) {
                hasNegCycle = true;
                break;
            }
        }

        if (hasNegCycle) {
            System.out.println(-1);
            return;
        }

        for (int i = 2; i <= N; i++) {
            System.out.println(dist[i] == Long.MAX_VALUE ? -1 : dist[i]);
        }
    }

}