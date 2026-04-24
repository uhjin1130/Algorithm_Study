import java.io.*;
import java.util.*;

public class Main {
    public static LinkedList<Character> password;
    public static char[] keyLog;
    public static int T;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            password = new LinkedList<>();
            keyLog = br.readLine().toCharArray();
            solve();
        }

    }

    public static void solve() {
        int head = 0;
        int cnt = 0;

        while (cnt < keyLog.length) {
            char c = keyLog[cnt];
            switch (c) {
                case '<':
                    if (head > 0)
                        head--;
                    break;
                case '>':
                    if (head < password.size())
                        head++;
                    break;
                case '-':
                    if (head > 0) {
                        password.remove(head - 1);
                        head--;
                    }
                    break;
                default:
                    password.add(head, c);
                    head++;
                    break;
            }
            cnt++;
        }

        StringBuilder sb = new StringBuilder();
        for (char ch : password)
            sb.append(ch);
        System.out.println(sb);
    }

}