import java.util.*;

class Solution {
    public int solution(int[][] cost, int[][] hint) {
        int answer = Integer.MAX_VALUE;
        int n = cost.length;

        // 번들은 총 n-1개 까지 가능한데 각 번들을 "산다/안 산다" 2가지 선택이 있으니 비트마스크 이용
        for(int mask = 0; mask < (1 << (n - 1)); mask++) {
            int[] ticketCount = new int[n + 1];
            int bundleCost = 0;
            
            for(int i = 0; i < n - 1; i++){ // i: hint 배열의 인덱스 (0 ~ n-2)
                if((mask & (1 << i)) != 0) { // mask의 i번째 비트가 켜져 있다 = 이 번들을 산다
                    bundleCost += hint[i][0];  // 번들 가격
                    for(int j = 1; j < hint[i].length; j++){ // hint[i][0]은 가격이니 j = 1부터
                        int ticketNum = hint[i][j]; // 이 번들에 들어있는 힌트권 번호
                        ticketCount[ticketNum]++; // 해당 번호의 힌트권 개수 누적
                    }
                }
            }
            
            int totalCost = 0;
            for(int k = 1; k <= n; k++) {
                int use = Math.min(ticketCount[k], n - 1);
                totalCost += cost[k - 1][use];
            }
            
            totalCost += bundleCost;
            answer = Math.min(totalCost, answer);
            
        }
        
        return answer;
    }
}