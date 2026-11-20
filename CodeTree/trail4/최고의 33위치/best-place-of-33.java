import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        // Please write your code here.
        int max = Integer.MIN_VALUE;
        
        int cnt = 0;
        for(int i = 0; i <= n - 3; i++) {
            for(int j = 0; j <= n - 3; j++) {
                cnt = 0;
                for(int a = 0; a < 3; a++) {
                    for(int b = 0; b < 3; b++) {
                        cnt += grid[i + a][j + b];
                    }
                }
                max = Math.max(max, cnt);
            }
        }

        System.out.println(max);
        
    }
}