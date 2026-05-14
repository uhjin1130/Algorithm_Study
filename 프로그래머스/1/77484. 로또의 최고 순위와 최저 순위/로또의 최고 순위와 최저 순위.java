import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int[] rank = {6, 6, 5, 4, 3, 2, 1};
        
        List<Integer> lottoWin = new ArrayList<>();
        for(int num : win_nums)
            lottoWin.add(num);
        
        int maxCnt = 0;
        int minCnt = 0;
        
        for(int i : lottos) {
            if(i == 0) {
                maxCnt++;
            } else if (lottoWin.contains(i)) {
                maxCnt++;
                minCnt++;
            }
        }
        
        answer[0] = rank[maxCnt];
        answer[1] = rank[minCnt];
        
        return answer;
    }
}