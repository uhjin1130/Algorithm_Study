import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private int time = 0;
	private ArrayList<Integer> number;

	public Main() throws IOException {
		int N = Integer.parseInt(bf.readLine());
		number = new ArrayList<>(N);
		StringTokenizer st = new StringTokenizer(bf.readLine());

		for (int i = 0; i < N; i++) {
			number.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(number);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= i; j++) {
				time += number.get(j);
			}
		}
		System.out.print(time);
	}

	public static void main(String[] args) throws IOException {
		new Main();
	}
}
