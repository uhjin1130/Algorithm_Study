import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] result = new int[4];
        String s;
        while ((s = br.readLine()) != null) {
            Arrays.fill(result, 0);
            for (char i : s.toCharArray()) {
                if (i >= 'a' && i <= 'z')
                    result[0]++;
                else if (i >= 'A' && i <= 'Z')
                    result[1]++;
                else if (i >= '0' && i <= '9')
                    result[2]++;
                else if (i == ' ')
                    result[3]++;
            }
            for (int j : result)
                System.out.print(j + " ");

            System.out.println();
        }
    }


}