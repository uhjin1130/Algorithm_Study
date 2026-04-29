import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=10;
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			int len = sc.nextInt();
            char[][] map = new char[8][8];
            
            for(int i = 0 ; i < 8; i++){
                String words = sc.next();
                for(int j = 0; j < 8; j++){
                    map[i][j] = words.charAt(j);
                }
            }
            
            int result = 0;
            
            for(int i = 0; i < 8; i++){
                for(int j = 0; j < 8; j++){
                    if(j+len <= 8){
                        StringBuilder horizontal = new StringBuilder();
                        for(int k = 0; k < len; k++){
                            horizontal.append(map[i][j+k]);
                        }
                        StringBuilder reverseHorizontal = new StringBuilder(horizontal).reverse();
                        if(horizontal.toString().equals(reverseHorizontal.toString()))
                            result++;
                    }
                    
                    if(i+len <= 8){
                        StringBuilder vertical = new StringBuilder();
                        for(int k = 0; k < len; k++){
                            vertical.append(map[i+k][j]);
                        }
                        StringBuilder reverseVertical= new StringBuilder(vertical).reverse();
                        if(vertical.toString().equals(reverseVertical.toString()))
                            result++;
                    }
                }
            }
            
            System.out.println("#"+test_case + " " + result);

		}
	}
}