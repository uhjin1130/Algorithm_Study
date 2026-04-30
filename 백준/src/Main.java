import java.io.*;
import java.util.*;

public class Main {
    public static int N, cnt;
    public static int[] board;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board =  new int[N];

        nQueen(0);

        System.out.println(cnt);

    } // main

    public static void nQueen(int depth){
        if(depth == N) {
            cnt++;
            return;
        }

        for(int i = 0; i < N; i++){
            board[depth] = i;
            if(check(depth)){
                nQueen(depth+1);
            }
        }
    }

    public static boolean check(int col){
        for(int i = 0; i < col; i++){
            if(board[i] == board[col])
                return false;
            else if (Math.abs(col - i)  == Math.abs(board[col] - board[i]))
                return false;
        }

        return true;
    }

} // class