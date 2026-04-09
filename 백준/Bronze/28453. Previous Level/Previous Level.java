import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= n; i++){
            int a = Integer.parseInt(st.nextToken());

            if (a == 300)
                System.out.print("1 ");
            else if(a < 300 && a >= 275)
                System.out.print("2 ");
            else if (a<275 && a>=250)
                System.out.print("3 ");
            else
                System.out.print("4 ");
        }

    }
}