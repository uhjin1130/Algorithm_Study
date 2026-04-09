import java.io.*;
import java.util.*;

public class Main{

    public static int[] cup = { 1, 2, 3 };
    public static int temp, tempA, tempB;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < n ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            for(int j = 0; j < 3; j++){
                if(a == cup[j]){
                    tempA = j;
                }
                if(b == cup[j]){
                    tempB = j;
                }
            }

            temp = cup[tempA];
            cup[tempA] = cup[tempB];
            cup[tempB] = temp;
        }

        System.out.println(cup[0]);
    }

}