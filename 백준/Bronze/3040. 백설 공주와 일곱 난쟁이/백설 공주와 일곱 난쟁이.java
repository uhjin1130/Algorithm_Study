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

        findDwarf(0,0);

        

    } // main

    public static void findDwarf(int cur, int cnt) {
        if(cnt == 7){
            if(checkSum()) {
                System.out.println(sb.toString());
                return;
            }
            return;
        }

        for(int i = cur; i < 9; i++){
            result[cnt] = dwarfs[i];
            findDwarf(i+1, cnt+1);
        }
    }

    public static boolean checkSum(){
        int sum = 0;
        sb = new StringBuilder();
        for(int i : result) {
            sb.append(i).append("\n");
            sum += i;
        }

        if(sum == 100)
            return true;
        else {
            sb = new StringBuilder();
            return false;
        }

    }

} // class