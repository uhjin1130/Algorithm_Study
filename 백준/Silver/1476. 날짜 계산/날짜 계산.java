import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int year = 1;
        int eCnt = 1;
        int sCnt = 1;
        int mCnt = 1;

        while (true) {
            if (eCnt != E || sCnt != S || mCnt != M) {
                eCnt++;
                sCnt++;
                mCnt++;
                if (eCnt > 15) eCnt = 1;
                if (sCnt > 28) sCnt = 1;
                if (mCnt > 19) mCnt = 1;
                year++;
            } else {
                break;
            }
        }

        System.out.println(year);

    }
}