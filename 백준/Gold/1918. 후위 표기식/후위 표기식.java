

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        char[] chars = input.toCharArray();

        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char c : chars) {
            if(c>='A' && c<='Z') {
                sb.append(c);
            } else {
                if(c == '('){
                    stack.push(c);
                }
                else if(c == ')'){
                    while(!stack.isEmpty() && stack.peek() != '(') {
                        sb.append(stack.pop());
                    }
                    if(!stack.isEmpty())
                        stack.pop();
                } else {
                    while(!stack.isEmpty() && stack.peek() != '(' && priority(stack.peek()) >= priority(c)) {
                        sb.append(stack.pop());
                    }
                    stack.push(c);
                }
            }
        }

        while(!stack.isEmpty())
            sb.append(stack.pop());
        System.out.println(sb);
    }
    public static int priority(char op){
        if(op=='+' || op=='-')
            return 1;
        if(op=='*' || op=='/')
            return 2;
        return 0;
    }
}
