

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            String[] split = s.split(" ");
            StringBuilder result = new StringBuilder();
            for(int j = 0; j < split.length; j++) {
                StringBuilder temp = new StringBuilder(split[j]);
                temp.reverse();
                result.append(temp).append(" ");
            }
            System.out.println(result.toString());
        }

    }
}