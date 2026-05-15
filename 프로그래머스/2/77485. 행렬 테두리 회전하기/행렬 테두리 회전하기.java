import java.util.*;

class Solution {
    public static int[][] map;
    
    public int[] solution(int rows, int columns, int[][] queries) {
        map = new int[rows + 1][columns + 1];
        
        int v = 1;
        for(int i = 1; i <= rows; i++){
            for(int j = 1; j <= columns; j++){
                map[i][j] = v;
                v++;
            }
        }
        int[] answer = new int[queries.length];
        int cur = 0;
        // 회전
        for(int cnt = 0; cnt < queries.length; cnt++){
            int r1 = queries[cnt][0];
            int c1 = queries[cnt][1];
            int r2 = queries[cnt][2];
            int c2 = queries[cnt][3];
            
            List<Integer> list = new ArrayList<>();
            
            int tmp = map[r1][c1];
            // 오른쪽으로 이동
            for(int c = c1 + 1; c <= c2; c++) {
                list.add(tmp);
                int tmp2 = map[r1][c];
                map[r1][c] = tmp;
                tmp = tmp2;
            }
            
            // 아래로 이동
            for(int r = r1 + 1; r <= r2; r++){
                list.add(tmp);
                int tmp2 = map[r][c2];
                map[r][c2] = tmp;
                tmp = tmp2;
            }
            
            // 왼쪽으로 이동
            for(int c = c2 - 1; c >= c1; c--) {
                list.add(tmp);
                int tmp2 = map[r2][c];
                map[r2][c] = tmp;
                tmp = tmp2;
            }
            
            // 위로 이동
            for(int r = r2 - 1; r >= r1; r--) {
                list.add(tmp);
                int tmp2 = map[r][c1];
                map[r][c1] = tmp;
                tmp = tmp2;
            }
            
            list.sort(Comparator.naturalOrder());
            answer[cur] = list.get(0);
            cur++;
        }
        
        return answer;
    }
} 