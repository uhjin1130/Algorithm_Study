class Solution {
    public static int n;
    public static boolean[] visited;
    public static boolean[][] graph;
    
    public int solution(int n, int[][] wires) {
        
        this.n = n;
        graph = new boolean[n+1][n+1];
        int answer = Integer.MAX_VALUE;
        
        for(int[] wire : wires) {
            graph[wire[0]][wire[1]] = true;
            graph[wire[1]][wire[0]] = true;
        }
        
        for(int[] wire : wires){
            graph[wire[0]][wire[1]] = false;
            graph[wire[1]][wire[0]] = false;
            
            visited = new boolean[n+1];
            int cnt = dfs(1);
            
            answer = Math.min(answer, Math.abs(cnt - (n - cnt)));
            
            graph[wire[0]][wire[1]] = true;
            graph[wire[1]][wire[0]] = true;
        }
        
        return answer;
    }
    
    public static int dfs(int node) {
        visited[node] = true;
        int count = 1;
        for(int i = 1; i <= n; i++){
            if(!visited[i] && graph[node][i]) {
                count += dfs(i);
            }
        }
        return count;
    }
}