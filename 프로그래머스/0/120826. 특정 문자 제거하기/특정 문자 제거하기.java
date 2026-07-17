import java.util.*;

class Solution {
    public String solution(String my_string, String letter) {
        String answer = "";
        
        char[] ch = my_string.toCharArray();
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < ch.length; i++){
            if(Character.toString(ch[i]).equals(letter)) {
                continue;
            }
            sb.append(ch[i]);
        }
        
        answer = sb.toString();
        
        return answer;
    }
}