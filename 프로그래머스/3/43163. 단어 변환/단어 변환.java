import java.util.*;

class Solution {
    
    public static int answer;
    
    public static class Node {
        
        String word;
        int cnt;
        
        public Node(String word, int cnt) {
            this.word = word;
            this.cnt = cnt;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        answer = bfs(begin, target, words);
        return answer;
    }
    
    public static int bfs(String begin, String target, String[] words) {
        Queue<Node> queue = new LinkedList<>();
        boolean[] visited = new boolean[words.length];
        
        queue.add(new Node(begin, 0));
        
        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            if(cur.word.equals(target)) {
                return cur.cnt;
            } else {
                for(int i = 0; i < words.length; i++){
                    if(visited[i] == false && isConvertible(cur.word, words[i])){
                        visited[i] = true;
                        queue.add(new Node(words[i], cur.cnt + 1));
                    }
                }
            }
        }
        
        return 0;
        
    }
    
    public static boolean isConvertible(String a, String b) {
        int diff = 0;
        for(int i = 0; i < a.length(); i++){
            char ca = a.charAt(i);
            char cb = b.charAt(i);
            
            if(ca != cb)
                diff++;
        }
        return diff == 1;
    }
    
    
}