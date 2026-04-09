import java.io.*;
import java.util.*;

public class Main {
    public static int MAX = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int result = 1;
        if(n==0){
            System.out.println(1);
        } else {
            for(int i = 1; i <= n; i++) {
                result *= i;
            }
            System.out.println(result);
        }
        
    }

}