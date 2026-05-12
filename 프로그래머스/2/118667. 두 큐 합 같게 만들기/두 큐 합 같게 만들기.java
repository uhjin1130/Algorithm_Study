import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int size = queue1.length + queue2.length + 1;
        
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        long sum1 = 0L;
        for(int n1 : queue1) {
            sum1 += n1;
            q1.offer(n1);
        }
        
        long sum2 = 0L;
        for(int n2 : queue2) {
            sum2 += n2;
            q2.offer(n2);
        }
        
        if(sum1 == sum2)
            return 0;
        else {
            int cnt = 0;
            int num1, num2;
            while(cnt <= size && !q1.isEmpty() && !q2.isEmpty()) {
                num1 = q1.peek();
                num2 = q2.peek();
                
                if(sum1 > sum2) {
                    q2.offer(q1.poll());
                    sum2 += num1;
                    sum1 -= num1;
                } else if (sum1 < sum2) {
                    q1.offer(q2.poll());
                    sum1 += num2;
                    sum2 -= num2;
                }
                
                cnt++;
                
                if(sum1 == sum2) {
                    return cnt;
                }
            }
            return -1;
        }
    }
}