import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int T; // 테스트 케이스
	static int M; // 가로
	static int N; // 세로
	static int K; // 배추 개수
	static int map[][];
	static boolean visit[][];
	static int dirX[] = { 0, 0, -1, 1 };
	static int dirY[] = { -1, 1, 0, 0 };
	static int now_x, now_y;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine()); // 테스트 케이스
		for (int i = 0; i < T; i++) {
		    StringTokenizer st = new StringTokenizer(br.readLine());
		    M = Integer.parseInt(st.nextToken());
		    N = Integer.parseInt(st.nextToken());
		    K = Integer.parseInt(st.nextToken());

		    map = new int[N][M];
		    visit = new boolean[N][M];

		    int x, y;

		    for (int j = 0; j < K; j++) {
		        st = new StringTokenizer(br.readLine()); // 각 배추의 좌표를 새로운 StringTokenizer로 읽기
		        x = Integer.parseInt(st.nextToken());
		        y = Integer.parseInt(st.nextToken());
		        map[y][x] = 1;
		    }

		    int count = 0;
		    for (int j = 0; j < N; j++) {
		        for (int k = 0; k < M; k++) {
		            if (map[j][k] == 1 && visit[j][k] == false) {
		                count++;
		                DFS(k, j);
		            }
		        }
		    }
		    sb.append(count).append('\n');
		}
		System.out.println(sb);
	}

	public static void DFS(int x, int y) {
		visit[y][x] = true;

		for (int i = 0; i < 4; i++) {
			now_x = x + dirX[i];
			now_y = y + dirY[i];
			
			if(Range_check() && visit[now_y][now_x] == false && map[now_y][now_x] == 1) {
				DFS(now_x,now_y);
			}
		}
	}
	
	public static boolean Range_check() {
		return (now_y < N && now_y >= 0 && now_x <M && now_x>=0);
	}

}