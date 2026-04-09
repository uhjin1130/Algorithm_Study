import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    private BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private int N;
    private int M;
    private HashSet<String> notHear = new HashSet<>();
    private TreeSet<String> result = new TreeSet<>();

    public Main() throws IOException {
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        setMap();
        getResult();
    }

    public void setMap() throws IOException {
        String name;
        for (int i = 1; i <= N; i++) {
            name = bf.readLine();
            if (name.length() <= 20) {
                notHear.add(name);
            }
        }
    }

    public void getResult() throws IOException {
        for (int j = 1; j <= M; j++) {
            String name = bf.readLine();
            if (name.length() <= 20 && notHear.contains(name)) {
                result.add(name);
            }
        }

        System.out.println(result.size());
        for (String name : result) {
            System.out.println(name);
        }
    }

    public static void main(String[] args) throws IOException {
        new Main();
    }
}
