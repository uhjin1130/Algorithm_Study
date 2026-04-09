import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int sticks = 0;
        int result = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '('){
                if(s.charAt(i+1) == ')'){
                    result += sticks;
                    i++;
                } else {
                    sticks++;
                }
            } else {
                sticks--;
                result++;
            }
        }
        System.out.println(result);
    }
}