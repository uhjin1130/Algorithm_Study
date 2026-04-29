import java.util.*;
import java.io.*;

class Solution {
    public static int startX, startY;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            char[][] map = new char[H][W];
            for (int i = 0; i < H; i++) {
                char[] arr = br.readLine().toCharArray();
                for (int j = 0; j < W; j++) {
                    map[i][j] = arr[j];
                    if (arr[j] == '<' || arr[j] == '>' || arr[j] == '^' || arr[j] == 'v') {
                        startX = j;
                        startY = i;
                    }
                }
            }

            int N = Integer.parseInt(br.readLine().trim());
            char[] operator = br.readLine().toCharArray();

            for (char op : operator) {
                switch (op) {
                    case 'U':
                        map[startY][startX] = '^'; 
                        if (startY - 1 >= 0 && map[startY - 1][startX] == '.') {
                            map[startY - 1][startX] = '^';
                            map[startY][startX] = '.';
                            startY--;
                        }
                        break;
                    case 'D':
                        map[startY][startX] = 'v';
                        if (startY + 1 < H && map[startY + 1][startX] == '.') {
                            map[startY + 1][startX] = 'v';
                            map[startY][startX] = '.';
                            startY++;
                        }
                        break;
                    case 'L':
                        map[startY][startX] = '<';
                        if (startX - 1 >= 0 && map[startY][startX - 1] == '.') {
                            map[startY][startX - 1] = '<';
                            map[startY][startX] = '.';
                            startX--;
                        }
                        break;
                    case 'R':
                        map[startY][startX] = '>';
                        if (startX + 1 < W && map[startY][startX + 1] == '.') {
                            map[startY][startX + 1] = '>';
                            map[startY][startX] = '.';
                            startX++;
                        }
                        break;
                    case 'S':
                        if (map[startY][startX] == '^') {
                            for (int i = startY - 1; i >= 0; i--) {
                                if (map[i][startX] == '*') { map[i][startX] = '.'; break; }
                                else if (map[i][startX] == '#') { break; }
                            }
                        } else if (map[startY][startX] == 'v') {
                            for (int i = startY + 1; i < H; i++) {
                                if (map[i][startX] == '*') { map[i][startX] = '.'; break; }
                                else if (map[i][startX] == '#') { break; }
                            }
                        } else if (map[startY][startX] == '<') {
                            for (int i = startX - 1; i >= 0; i--) {
                                if (map[startY][i] == '*') { map[startY][i] = '.'; break; }
                                else if (map[startY][i] == '#') { break; }
                            }
                        } else if (map[startY][startX] == '>') {
                            for (int i = startX + 1; i < W; i++) {
                                if (map[startY][i] == '*') { map[startY][i] = '.'; break; }
                                else if (map[startY][i] == '#') { break; }
                            }
                        }
                        break;
                }
            }

            sb.append("#").append(test_case).append(" ");
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) sb.append(map[i][j]);
                sb.append("\n");
            }
        }
        System.out.print(sb);
    }
}