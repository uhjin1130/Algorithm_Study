import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if(s.equals("push")){
                int num = Integer.parseInt(st.nextToken());
                stack.push(num);
            } else if (s.equals("pop")){
                System.out.println(stack.isEmpty() ? "-1" : stack.pop());
            } else if (s.equals("size")) {
                System.out.println(stack.size());
            } else if (s.equals("empty")) {
                System.out.println(stack.isEmpty() ? 1 : 0);
            } else if (s.equals("top")) {
                System.out.println(stack.isEmpty() ? "-1" : stack.peek());
            }
        }

    }
}