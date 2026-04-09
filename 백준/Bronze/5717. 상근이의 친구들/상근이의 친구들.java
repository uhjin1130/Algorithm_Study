import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int m;
        int f;
        while(true){
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            f = Integer.parseInt(st.nextToken());

            if(m == 0 && f == 0)
                break;
            else
                System.out.println(m+f);
        }
    }
}