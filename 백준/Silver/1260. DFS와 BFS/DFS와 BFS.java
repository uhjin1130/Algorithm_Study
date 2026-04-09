import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	static int N, M, V; // 정점의 개수, 간선의 개수, 출발점
	static Scanner sc = new Scanner(System.in);

	static class Graph {
		private boolean visit[]; // 방문여부
		private int adj_mat[][]; // 인접 행렬을 이용한 그래프 표현
		private Stack<Integer> stack;
		private Queue<Integer> queue;

		public Graph() {
			N = sc.nextInt();
			M = sc.nextInt();
			V = sc.nextInt();
			adj_mat = new int[N + 1][N + 1];
			visit = new boolean[N + 1];
			stack = new Stack<>();
			queue = new LinkedList<>();
		}

		public void addEdge(int start, int end) {
			adj_mat[start][end] = 1;
			adj_mat[end][start] = 1;
		}

		public void DFS() {
			stack.push(V);

			int currentVertex;

			while (!stack.isEmpty()) {
				currentVertex = stack.pop();

				if (!visit[currentVertex]) {
					System.out.print(currentVertex + " ");
					visit[currentVertex] = true;
				}

				// 인접 정점 중에서 가장 작은 값부터 스택에 추가
				for (int i = N; i > 0; i--) {
					if (adj_mat[currentVertex][i] == 1 && !visit[i]) {
						stack.push(i);
					}
				}
			}
		}

		public void BFS() {
			visit = new boolean[N + 1];
			int currentVertex = V;
			
			visit[currentVertex] = true;
			System.out.print(currentVertex + " ");
			
			queue.offer(currentVertex);
			while(!queue.isEmpty()) {
				currentVertex = queue.poll();
				
				for(int i=1; i<=N; i++) {
					if(adj_mat[currentVertex][i] == 1 && !visit[i]) {
						queue.offer(i);
						visit[i] = true;
						System.out.print(i + " ");
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		Graph graph = new Graph();

		int start, end;

		// 간선 정보 입력
		for (int i = 0; i < M; i++) {
			start = sc.nextInt();
			end = sc.nextInt();
			graph.addEdge(start, end);
		}

		graph.DFS();
		System.out.println();
		graph.BFS();
	}
}
