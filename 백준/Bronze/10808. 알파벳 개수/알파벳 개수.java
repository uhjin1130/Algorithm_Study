import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        char[] arr = s.toCharArray();
        int[] result = new int[26];
        for(int i = 0; i < arr.length; i++){
            result[arr[i] - 'a']++;
        }
        for(int i : result){
            System.out.print(i + " ");
        }
    }

}