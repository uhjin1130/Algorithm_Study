import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        int[] result = new int[N];

        for(int i = N - 1; i >= 0; i--){
            while(!stack.isEmpty() && arr[stack.peek()] <= arr[i]){
                stack.pop();
            }
            result[i] = stack.isEmpty() ? -1 : arr[stack.peek()];
            stack.push(i);
        }

        StringBuilder sb = new StringBuilder();
        for(int i : result){
            sb.append(i).append(" ");
        }
        System.out.println(sb.toString());
    }
}
