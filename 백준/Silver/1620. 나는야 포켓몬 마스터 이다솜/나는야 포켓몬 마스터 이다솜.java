import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	HashMap<Integer, String> poketmonName;
	HashMap<String, Integer> poketmonNumber;
	private int N, M; // 포켓몬 수, 문제 개수
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	String s = bf.readLine();
	StringTokenizer st = new StringTokenizer(s);

	public Main() throws IOException {
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		poketmonName = new HashMap<>(N);
		poketmonNumber = new HashMap<>(N);

		setBook();
		findPoketmon();
	}

	public void setBook() throws IOException {
		String name;
		for (int i = 1; i <= N; i++) {
			name = bf.readLine();
			poketmonName.put(i, name);
			poketmonNumber.put(name, i);
		}
	}

	public void findPoketmon() throws IOException {
		int questionNum = M;
		while (questionNum != 0) {
			String question = bf.readLine();
			if (isInteger(question)) {
				int number = Integer.parseInt(question);
				if (number >= 1 && number <= N) {
					System.out.println(poketmonName.get(number));
				} else {
					System.out.println("Invalid Pokemon number");
				}
			} else {
				// 이름일 경우
				Integer number = poketmonNumber.get(question);
				if (number != null) {
					System.out.println(number);
				} else {
					System.out.println("Invalid Pokemon name");
				}
			}
			questionNum--;
		}
	}

	public boolean isInteger(String input) {
		try {
			Integer.parseInt(input);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static void main(String[] args) throws IOException {
		new Main();
	}
}
