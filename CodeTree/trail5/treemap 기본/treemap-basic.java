import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        TreeMap<Integer, Integer> tree = new TreeMap<>();

        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int key;
            String cmd = st.nextToken();

            switch(cmd){
                case "add": 
                    key = Integer.parseInt(st.nextToken());
                    int value = Integer.parseInt(st.nextToken());
                    tree.put(key, value);
                    break;

                case "remove":
                    key = Integer.parseInt(st.nextToken());
                    tree.remove(key);
                    break;

                case "find":
                    key = Integer.parseInt(st.nextToken());
                    if(tree.containsKey(key))
                        System.out.println(tree.get(key));
                    else
                        System.out.println("None");
                    break;

                case "print_list":
                    if(tree.isEmpty()) {
                        System.out.println("None");
                        break;
                    }

                    StringBuilder sb = new StringBuilder();
                    for(int v : tree.values())
                        sb.append(v + " ");
                    System.out.println(sb.toString());

                    break;
            }
        }
    }
}