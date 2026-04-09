import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	HashMap<String, String> password;

	public Main() throws IOException {
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		password = new HashMap<String, String>();

		for (int i = 0; i < N; i++) {
			String address_password = bf.readLine();
			st = new StringTokenizer(address_password);

			String address = st.nextToken();
			String passwd = st.nextToken();

			password.put(address, passwd);
		}

		for (int j = 0; j < M; j++) {
			String address = bf.readLine();
			if (password.containsKey(address)) {
				System.out.println(password.get(address));
			}
		}
	}

	public static void main(String[] args) throws IOException {
		new Main();
	}
}
