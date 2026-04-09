

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        StringBuilder sb = new StringBuilder();
        boolean tagCheck = false;
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '<'){
                while(!stack.isEmpty())
                    sb.append(stack.pop());
                sb.append(c);
                tagCheck = true;
            }
            else if(c == '>'){
                sb.append(c);
                tagCheck = false;
            }
            else if(tagCheck){
                sb.append(c);
            }
            else if(c == ' '){
                while(!stack.isEmpty())
                    sb.append(stack.pop());
                sb.append(' ');
            }
            else{
                stack.push(c);
            }
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        System.out.println(sb.toString());
    }
}
