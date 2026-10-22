import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int w : works)
            pq.add(w);
        
        for(int i = 0; i < n; i++){
            int cur = pq.poll();
            if(cur == 0)
                break;
            pq.add(cur - 1);
        }
        
        int size = pq.size();
        for(int j = 0; j < size; j++) {
            int x = pq.poll();
            answer += (long)x * x;
        }
        
        return answer;
    }
}