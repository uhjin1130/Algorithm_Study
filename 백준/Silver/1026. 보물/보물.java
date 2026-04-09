import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

	public Main() throws IOException {
		int n = Integer.parseInt(bf.readLine());

		Integer[] A = new Integer[n];
		Integer[] B = new Integer[n];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(A);
		Arrays.sort(B, Collections.reverseOrder());

		int s = 0;
		for (int i = 0; i < n; i++) {
			s += A[i] * B[i];
		}
		System.out.print(s);
	}

	public static void main(String[] args) throws IOException {
		new Main();
	}
}
