class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        long left = 1;
        long right = 0;
        for(int t : times){
            right = Math.max(right, t);
        }
        
        right *= n;
        
        while(left <= right) {
            long mid = (left + right) / 2;
            long check = 0;
            
            for(int t : times) {
                check += mid / t;
            }
            
            if(check >= n) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return answer;
    }
}