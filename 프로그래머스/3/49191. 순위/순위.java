class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        boolean[][] win = new boolean[n + 1][n + 1];
        
        for(int i = 0; i < results.length; i++){
            int A = results[i][0];
            int B = results[i][1];
            win[A][B] = true;
        }
        
        for(int k = 1; k <= n; k++){
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    if(win[i][k] && win[k][j])
                        win[i][j] = true;
                }
            }
        }
        
        for(int i = 1; i <= n; i++){
            int cnt = 0;
            for(int j = 1; j <= n; j++){
                if(win[i][j] || win[j][i])
                    cnt++;
            }
            if(cnt == n - 1)
                answer++;
        }
        
        return answer;
    }
}