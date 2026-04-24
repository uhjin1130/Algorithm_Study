import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] group = new int[n + 1];
        for(int i = 0; i <= n; i++){
            group[i] = i;
        }

        for(int i = 1; i <= m; i++){
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            switch (op) {
                case 0:
                    int ra = unionFind(group, a);
                    int rb = unionFind(group, b);
                    if(ra != rb)
                        group[ra] = rb;
                    break;
                case 1:
                    int fa = unionFind(group, a);
                    int fb = unionFind(group, b);
                    if(fa == fb)
                        System.out.println("YES");
                    else
                        System.out.println("NO");
                default:
                    break;
            }
        }


    }

    public static int unionFind(int[] group, int num) {
        if(num == group[num])
            return num;
        else
            return group[num] = unionFind(group, group[num]);
    }

}