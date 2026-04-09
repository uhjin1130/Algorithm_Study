import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	Deque<Integer> deque = new LinkedList<>();

	public Main() throws IOException {
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= n; i++) {
			deque.add(i);
		}

		int location[] = new int[m];
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < m; i++) {
			location[i] = Integer.parseInt(st.nextToken());
		}

		int count = 0;

		for (int i = 0; i < m; i++) {
			int half;
			if (deque.size() % 2 == 0) {
				half = deque.size() / 2 - 1;
			} else {
				half = deque.size() / 2;
			}

			int find_index = ((LinkedList<Integer>) deque).indexOf(location[i]);

			if (find_index <= half) {
				for (int j = 0; j < find_index; j++) {
					int temp = deque.pollFirst();
					deque.addLast(temp);
					count++;
				}
			} else {
				for (int j = 0; j < deque.size() - find_index; j++) {
					int temp = deque.pollLast();
					deque.addFirst(temp);
					count++;
				}
			}
			deque.pollFirst();
		}

		System.out.print(count);
	}

	public static void main(String[] args) throws IOException {
		new Main();
	}
}
