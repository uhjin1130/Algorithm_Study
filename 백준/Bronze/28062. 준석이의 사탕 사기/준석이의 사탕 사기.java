import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> odds = new ArrayList<>();
        long evenSum = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(num % 2 == 0) {
                evenSum += num;
            } else {
                odds.add(num);
            }
        }

        if(odds.size() % 2 == 0)
            for(int i : odds)
                evenSum += i;
        else{
            Collections.sort(odds);
            long oddSum = 0;
            for(int i : odds)
                oddSum += i;
            evenSum += oddSum - odds.get(0);
        }

        System.out.println(evenSum);
    }
}