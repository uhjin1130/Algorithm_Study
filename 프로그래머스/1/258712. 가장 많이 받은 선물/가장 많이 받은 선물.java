import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int N = friends.length;
        Map<String, Integer> map = new HashMap<>();
        int[][] arr = new int[N][N];

        for(int i = 0; i < N; i++) {
            map.put(friends[i], i);
        }
        
        int from, to;
        for(int i = 0; i < gifts.length; i++){
            from = map.get(gifts[i].split(" ")[0]);
            to = map.get(gifts[i].split(" ")[1]);
            arr[from][to]++;
        }
        
        int[] giftScore = new int[N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                giftScore[i] += arr[i][j];
                giftScore[j] -= arr[i][j];
            }
        }
        
        int[] give = new int[N];
        for(int i = 0; i < N; i++){
            for(int j = i + 1; j < N; j++){
                if(arr[i][j] > arr[j][i])
                    give[i]++;
                else if (arr[i][j] < arr[j][i])
                    give[j]++;
                else {
                    if(giftScore[i] == giftScore[j])
                        continue;
                    else if (giftScore[i] > giftScore[j])
                        give[i]++;
                    else
                        give[j]++;
                }
            }
        }
        
        for(int i : give)
            answer = Math.max(i, answer);
        
        return answer;
    }
}