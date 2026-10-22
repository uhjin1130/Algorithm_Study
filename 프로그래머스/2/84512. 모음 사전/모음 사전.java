import java.util.*;

class Solution {
    
    public static int cnt = 0;
    public static int answer = 0;
    public static String[] vowels = {"A", "E", "I", "O", "U"};
    
    public int solution(String word) {
        dfs(word, "");
        return answer;
    }
    
    public static void dfs(String word, String cur) {
        if(cur.length() != 0) {
            cnt++;
            if(cur.equals(word))
                answer = cnt;
        }
        
        if(cur.equals(word) || cur.length() == 5)
            return;
        
        for(int i = 0; i < 5; i++)
            dfs(word, cur + vowels[i]);
    }
}