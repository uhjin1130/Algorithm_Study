import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println("int a;");

        for(int i = 1 ; i <= n ;i++){
            System.out.print("int ");
            for(int j = 1 ; j <= i ;j++){
                System.out.print("*");
            }
            if(i == 1)
                System.out.println("ptr = &a;");
            else if (i == 2)
                System.out.println("ptr2 = &ptr;");
            else
                System.out.println("ptr"+i+" = &ptr" + (i-1) + ";");
        }
    }
}