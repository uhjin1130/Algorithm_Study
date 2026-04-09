import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Character> left = new ArrayDeque<>(), right = new ArrayDeque<>();

        String s = br.readLine();
        for(char c : s.toCharArray()) 
            left.addLast(c);

        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            String[] tokens = br.readLine().trim().split(" ");
            String cmd = tokens[0];
            switch(cmd) {
                case "P":
                    left.addLast(tokens[1].charAt(0));
                    break;
                case "L":
                    if(!left.isEmpty()) 
                        right.addFirst(left.removeLast());
                    break;
                case "D":
                    if(!right.isEmpty()) 
                        left.addLast(right.removeFirst());
                    break;
                case "B":
                    if(!left.isEmpty()) 
                        left.removeLast();
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        
        for(char c : left) 
            sb.append(c);
        
        while(!right.isEmpty()) 
            sb.append(right.removeFirst());
        
        System.out.println(sb);
    }
}