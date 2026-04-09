import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i = 1; i <= N; i++) {
            String s = br.readLine();
            char[] chars = s.toCharArray();
            Stack<Character> stack = new Stack<>();
            Boolean check = true;
            for(int j = 0; j < chars.length; j++) {
                if(chars[j] == '(') {
                    stack.push(chars[j]);
                } else {
                    if(stack.isEmpty()) {
                        check = false;
                        break;
                    }
                    stack.pop();
                }

            }
            if(stack.isEmpty() && check)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}