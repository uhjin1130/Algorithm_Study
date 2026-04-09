import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String a = st.nextToken() + st.nextToken();
        String b = st.nextToken() + st.nextToken();
        
        long A = Long.parseLong(a);
        long B = Long.parseLong(b);
        System.out.println(A + B);
    }

}