import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // Please write your code here
        
        StringTokenizer st;

        HashMap<Integer, Integer> hash = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            
            String command = st.nextToken();
            int k;

            switch(command) {
                case "add" :
                    k = Integer.parseInt(st.nextToken());
                    int v = Integer.parseInt(st.nextToken());
                    hash.put(k, v);
                    break;
                
                case "remove" :
                    k = Integer.parseInt(st.nextToken());
                    hash.remove(k);
                    break;

                case "find" :
                    k = Integer.parseInt(st.nextToken());
                    if(hash.containsKey(k))
                        sb.append(hash.get(k) + "\n");
                    else
                        sb.append("None\n");
                    break;
            }

        }

        System.out.println(sb.toString());
    }
}