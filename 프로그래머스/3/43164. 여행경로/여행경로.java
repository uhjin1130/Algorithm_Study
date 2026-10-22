import java.util.*;

class Solution {
    
    public static String[] answer;
    public static boolean[] used;
    public static ArrayList<String> path = new ArrayList<>();
    public static boolean found = false;
    
    public String[] solution(String[][] tickets) {
        answer = new String[tickets.length + 1];
        used = new boolean[tickets.length];
        
        // 1) 정렬 : 출발지 -> 도착지 알파벳순
        Arrays.sort(tickets, (a, b) -> {
            if(a[0].equals(b[0])) // 출발지가 같으면 도착지로 비교
                return a[1].compareTo(b[1]); 
            return a[0].compareTo(b[0]); // 다르면 출발지로 비교
        });
        
        // 2) 시작 공항 ICN을 경로에 먼저 넣고 DFS 시작
        path.add("ICN");
        dfs("ICN", 0, tickets);
        
        return answer;
    }
    
    public static void dfs(String cur, int cnt, String[][] tickets) {
        if(cnt == tickets.length) {
            for(int i = 0; i < path.size(); i++){
                answer[i] = path.get(i);
            }
            found = true;
            return;
        }
        
        for(int i = 0; i < tickets.length; i++){
            if(found)
                break;
            if(!used[i] && tickets[i][0].equals(cur)) {
                used[i] = true;
                path.add(tickets[i][1]);
                dfs(tickets[i][1], cnt + 1, tickets);
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}