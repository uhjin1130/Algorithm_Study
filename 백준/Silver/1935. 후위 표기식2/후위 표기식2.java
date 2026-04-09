import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        Double[] arr = new Double[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Double.parseDouble(br.readLine());
        }

        Stack<Double> stack = new Stack<>();
        char[] chars = s.toCharArray();
        int index = 0;

        for (char c : chars) {
            if (c >= 'A' && c <= 'Z') {
                stack.push(arr[c - 'A']);
                index++;
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                Double b = stack.pop();
                Double a = stack.pop();
                Double result;

                switch (c) {
                    case '+':
                        result = a + b;
                        break;
                    case '-':
                        result = a - b;
                        break;
                    case '*':
                        result = a * b;
                        break;
                    case '/':
                        result = a / b;
                        break;
                    default:
                        result = 0.0;
                }
                stack.push(result);
            }
        }

        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println(df.format(stack.pop()));
    }
}