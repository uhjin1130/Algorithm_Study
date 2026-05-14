import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        String changed = Integer.toString(n, k);
        String[] arr = changed.split("0");
        
        for(String s : arr) {
            if (s.equals(""))
                continue;
            
            if(isPrime(Double.parseDouble(s)))
                answer++;
        }
        
        return answer;
    }
    
    public static boolean isPrime(double n) {
        if(n <= 1)
            return false;
        if(n <= 3)
            return true;
        
        for(double i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0)
                return false;
        }
        return true;
    }
}