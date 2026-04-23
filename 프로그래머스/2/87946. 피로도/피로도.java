import java.util.*;

class Solution {
    public static int answer = Integer.MIN_VALUE;
    public static boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        int n = dungeons.length;
        visited = new boolean[n];
        
        adventure(k, dungeons, 0);
        
        return answer;
    }
    
    public static void adventure(int k, int[][] dungeons, int cnt) {
        answer = Math.max(answer, cnt);
        
        for(int i = 0; i < dungeons.length; i++){
            if(k >= dungeons[i][0] && !visited[i]) {
                visited[i] = true;
                adventure(k - dungeons[i][1], dungeons, cnt+1);
                visited[i] = false;
            }
        }
    }
}