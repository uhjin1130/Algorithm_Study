import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        double d1 = Integer.parseInt(st.nextToken());
        double d2 = Integer.parseInt(st.nextToken());
        double d3 = Integer.parseInt(st.nextToken());

        double a = (d1 + d2 + d3) / 2 - d3;
        double b = (d1 + d2 + d3) / 2 - d2;
        double c = (d1 + d2 + d3) / 2 - d1;

        if (a <= 0 || b <= 0 || c <= 0) {
            System.out.println("-1");
            return;
        } else {
            System.out.println("1");
            System.out.println(a + " " + b + " " + c);
        }
    }
}

/*
 * d1 = a + b
 * d2 = a + c
 * d3 = b + c
 * 
 * a = d1 - b
 * b = d3 - c
 * c = d2 - a
 * 
 * (d1+d2+d3) / 2 = a+b+c
 * 
 */