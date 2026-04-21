import java.io.*;
import java.util.*;

public class Main {
    public static int[] dwarfs = new int[9];
    public static int[] result = new int[7];
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            dwarfs[i] = Integer.parseInt(br.readLine());
        }

        findDwarf(0,0, 0);

        System.out.println(sb.toString());
        

    } // main

    public static void findDwarf(int cur, int cnt,  int sum) {
        if(cnt == 7){
            if(sum == 100) {
                for(int i : result)
                    sb.append(i).append("\n");
                return;
            }
            return;
        }

        for(int i = cur; i < 9; i++){
            result[cnt] = dwarfs[i];
            findDwarf(i+1, cnt+1, sum + result[cnt]);
        }
    }

} // class