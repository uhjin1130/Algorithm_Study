import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        for (int i = 0; i < T; i++) {
           StringTokenizer st = new StringTokenizer(bf.readLine());
           int a = Integer.parseInt(st.nextToken());
           int b = Integer.parseInt(st.nextToken());

           int bigger = Math.max(a, b);
           int smaller = Math.min(a, b);
           int cnt = 1;
           int result = 0;
           while(true){
               int temp = bigger*cnt;
               if(temp % smaller == 0){
                   result = temp;
                   break;
               }
               else
                   cnt++;
           }
            System.out.println(result);
        }

    }

}