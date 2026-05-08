import java.util.*;
import java.io.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        String[] arr = s.split(" ");
        
        for(String str : arr) {
            int n = Integer.parseInt(str);
            if(n < min)
                min = n;
            if(n > max)
                max = n;
        }
        
        answer = min + " " + max;
        
        return answer;
    }
}