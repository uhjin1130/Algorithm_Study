import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if(a[2] != b[2]) // 소요 시간
                return a[2] - b[2];
            else {
                if(a[1] != b[1]) // 작업 요청 시간
                    return a[1] - b[1];
                else
                    return a[0] - b[0]; // 작업 번호
            }
        });
        
        int[][] list = new int[jobs.length][3]; // [번호, 요청, 소요]
        for(int i = 0; i < jobs.length; i++){
            list[i][0] = i;
            list[i][1] = jobs[i][0];
            list[i][2] = jobs[i][1];
        }
        
        Arrays.sort(list, (a, b) -> a[1] - b[1]);
        
        int now = 0; // 현재 시각
        int idx = 0; // list에서 큐에 넣은 작업 수
        int sum = 0; // 반환 시간 합계
        int done = 0; // 끝난 작업 수
        
        while(done < jobs.length) {
            while (idx < list.length && list[idx][1] <= now) {
                pq.add(list[idx]);
                idx++;
            }
            
            if(pq.isEmpty()) {
                now = list[idx][1];
                continue;
            }
            
            int[] cur = pq.poll();
            now += cur[2];
            sum += now - cur[1];
            done++;
        }
        
        answer = sum / done;
        
        return answer;
    }
}