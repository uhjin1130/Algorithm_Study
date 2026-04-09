import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N+1];
        arr[0] = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N+1];
        dp[0] = 0;
        int length = 0;

        for(int i = 1; i <= N; i++){
            for(int j = 0; j < i; j++){
                if(arr[i] > arr[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    length = Math.max(length, dp[i]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(length+"\n");

        Stack<Integer> stack = new Stack<>();
        for(int i = N; i >= 1; i--){
            if(dp[i] == length){
                stack.push(arr[i]);
                length--;
            }
        }

        while(!stack.isEmpty()){
            sb.append(stack.pop()+" ");
        }

        System.out.println(sb.toString());

    }

}