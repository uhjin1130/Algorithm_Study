import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            char[] p = br.readLine().toCharArray();
            int n = Integer.parseInt(br.readLine());
            String[] inputs = br.readLine().replaceAll("[\\[\\]]", "").split(",");
            Deque<String> deque = new LinkedList<>();
            if (n > 0) {
                for (String s : inputs) {
                    deque.offer(s);
                }
            }

            boolean isReverse = false;
            boolean isError = false;

            for (char c : p) {
                if (c == 'R')
                    isReverse = !isReverse;
                else if (c == 'D') {
                    if (deque.isEmpty()) {
                        isError = true;
                        break;
                    }
                    if (isReverse)
                        deque.pollLast();
                    else
                        deque.pollFirst();
                }
            }

            if(isError)
                sb.append("error\n");
            else {
                List<String> result = new ArrayList<>(deque);
                if(isReverse)
                    Collections.reverse(result);

                sb.append("[")
                        .append(String.join(",", result))
                        .append("]\n");
            }
        }

        System.out.println(sb.toString());


    }
}