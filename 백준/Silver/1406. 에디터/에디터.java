import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Character> left = new LinkedList<>(), right = new LinkedList<>();

        String s = br.readLine();
        for (char c : s.toCharArray()) {
            left.add(c);
        }

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] op = br.readLine().trim().split(" ");
            switch (op[0]) {
                case "L":
                    if(!left.isEmpty())
                        right.addFirst(left.removeLast());
                    break;
                case "D":
                    if(!right.isEmpty())
                        left.add(right.removeFirst());
                    break;
                case "B":
                    if(!left.isEmpty())
                        left.removeLast();
                    break;
                case "P":
                    left.addLast(op[1].charAt(0));
                    break;

                default:
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(char cl : left)
            sb.append(cl);
        for(char cr : right)
            sb.append(cr);

        System.out.println(sb.toString());

    }

}