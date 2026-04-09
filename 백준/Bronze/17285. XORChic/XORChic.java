import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        char key = (char)(s.charAt(0)^'C');

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            sb.append((char)(s.charAt(i) ^ key));
        }

        System.out.println(sb.toString());

    }
}