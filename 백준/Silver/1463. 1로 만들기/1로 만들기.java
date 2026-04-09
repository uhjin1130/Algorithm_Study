import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private int x;

	public Main() throws IOException {
		StringTokenizer st = new StringTokenizer(bf.readLine());
		x = Integer.parseInt(st.nextToken());

		System.out.print(caculate(x, 0));

	}

	public int caculate(int x, int count) {
		if(x<2) {
			return count;
		}
		return Math.min(caculate(x/2,count+1+(x%2)), caculate(x/3,count+1+(x%3)));
	}

	public static void main(String[] args) throws IOException {
		new Main();
	}
}
