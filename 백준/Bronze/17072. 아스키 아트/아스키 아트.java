import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] img=  new char[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                int R = Integer.parseInt(st.nextToken());
                int G = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                int intensity = 2126*R + 7152*G + 722*B;

                char ch;
                if(intensity >= 2040000)
                    ch = '.';
                else if (intensity >= 1530000)
                    ch = '-';
                else if (intensity >= 1020000)
                    ch = '+';
                else if (intensity >= 510000)
                    ch = 'o';
                else
                    ch = '#';

                img[i][j] = ch;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                sb.append(img[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());



    }

}