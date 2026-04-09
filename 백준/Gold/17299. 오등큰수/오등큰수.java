import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] freq = new int[1000001];
        for (int i : arr)
            freq[i]++;

        Stack<Integer> stack = new Stack<>();
        int[] ngf = new int[N];
        for (int i = N - 1; i >= 0; i--) {
            while (!stack.isEmpty() && freq[arr[stack.peek()]] <= freq[arr[i]]) {
                stack.pop();
            }
            ngf[i] = stack.isEmpty() ? -1 : arr[stack.peek()];
            stack.push(i);
        }


        StringBuilder sb = new StringBuilder();
        for (int i : ngf)
            sb.append(i).append(" ");
        System.out.println(sb);
    }
}