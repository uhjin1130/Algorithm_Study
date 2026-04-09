

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();

        StringBuilder sb = new StringBuilder();
        for(String str : s.split("")) {
            if(str.equals("l"))
                sb.append('L');
            else
                sb.append('i');
        }
        System.out.println(sb.toString());
    }
}