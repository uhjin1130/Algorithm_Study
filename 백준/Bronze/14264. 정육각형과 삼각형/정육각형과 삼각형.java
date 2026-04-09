import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int sideLength = Integer.parseInt(st.nextToken());

        double area = 0.5 * sideLength * (sideLength * Math.sqrt(3) / 2);

        System.out.println(area);
    }
}