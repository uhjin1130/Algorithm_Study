import java.util.*;

class Solution {

    public static TreeMap<Integer, Integer> tree = new TreeMap<>();
    
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        for(int i = 0; i < operations.length; i++){
            String[] op = operations[i].split(" ");
            String cmd = op[0];
            int num = Integer.parseInt(op[1]);
            
            if(cmd.equals("I")) {
                tree.put(num, tree.getOrDefault(num, 0) + 1);
            } else {
                if(tree.isEmpty())
                    continue;
                else if (num == 1) {
                    int key = tree.lastKey();
                    int cnt = tree.get(key);
                    if(cnt == 1)
                        tree.remove(key);
                    else
                        tree.put(key, cnt - 1);
                } else {
                    int key = tree.firstKey();
                    int cnt = tree.get(key);
                    if(cnt == 1)
                        tree.remove(key);
                    else
                        tree.put(key, cnt - 1);
                }
            }
            
        }
        
        if(!tree.isEmpty()) {
            answer[0] = tree.lastKey();
            answer[1] = tree.firstKey();
        }
        
        return answer;
    }
}