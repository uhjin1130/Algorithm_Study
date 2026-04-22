import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][2];

        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 2; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(map, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0])
                    return o1[1] - o2[1];
                else
                    return o1[0] - o2[0];
            }
        });

        StringBuilder sb = new StringBuilder();
        for(int[] xy : map)
            sb.append(xy[0]).append(" ").append(xy[1]).append("\n");

        System.out.println(sb.toString());

    } // main

} // class