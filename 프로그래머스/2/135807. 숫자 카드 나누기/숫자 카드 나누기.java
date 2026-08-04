import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        int A = arrayA[0];
        for(int i = 1; i < arrayA.length; i++){
            A = gcd(arrayA[i], A);
        }
        
        int B = arrayB[0];
        for(int i = 1; i < arrayB.length; i++){
            B = gcd(arrayB[i], B);
        }
        
        if(!divide(A, arrayB)) {
            answer = Math.max(answer, A);
        }
        
        if(!divide(B, arrayA)) {
            answer = Math.max(answer, B);
        }
        
        return answer;
    }
    
    public static int gcd(int x, int y){
        if(y == 0)
            return x;
        return gcd(y, x % y);
    }
    
    public static boolean divide(int N, int[] array) {
        boolean result = false;
        
        for(int i = 0; i < array.length; i++){
            if(array[i] % N == 0)
                result = true;
        }
        
        return  result;
    }
}
