import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        arr[0] = -1;
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int next = 1;

        for(int i = 1; i <= n; i++){
            int temp = arr[i];

            while(next <= temp){
                stack.push(next++);
                sb.append("+").append("\n");
            }

            if(stack.isEmpty() || !stack.peek().equals(temp)){
                System.out.println("NO");
                return;
            }
            stack.pop();
            sb.append("-").append("\n");
        }

        System.out.println(sb.toString());

    }
}