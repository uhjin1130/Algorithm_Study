import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        char[] arr = s.toCharArray();

        StringBuilder sb = new StringBuilder();
        for (char i : arr) {
            if ((i >= 'A' && i <= 'Z') || (i >= 'a' && i <= 'z')) {
                char base = (i>='a'?'a':'A');
                sb.append((char)((i-base+13)%26+base));
            } else {
                sb.append(i);
            }
        }
        System.out.println(sb.toString());
    }


}
