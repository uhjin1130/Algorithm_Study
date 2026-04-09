import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Hashtable;
import java.util.StringTokenizer;

public class Main {
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private Hashtable<String, Integer> Cloth;

	public Main() throws IOException {
		int n = Integer.parseInt(bf.readLine());
		while (n != 0) {
			int cloth = Integer.parseInt(bf.readLine());
			Cloth = new Hashtable<String, Integer>(cloth);

			for (int i = 0; i < cloth; i++) {
				String getClothes = bf.readLine();
				StringTokenizer st = new StringTokenizer(getClothes);

				st.nextToken();
				String part = st.nextToken();

				if (Cloth.containsKey(part)) {
					Cloth.put(part, Cloth.get(part) + 1);
				} else {
					Cloth.put(part, 1);
				}
			}
			
			int result = 1;
			
			for(int count : Cloth.values())
				result *= (count + 1);
			
			System.out.println(result - 1);

			n--;
		}
	}

	public static void main(String[] args) throws IOException {
		new Main();
	}
}
