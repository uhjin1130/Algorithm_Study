import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] congressman = new int[n];

        for (int i = 0; i < n; i++) {
            int vote = Integer.parseInt(br.readLine());
            congressman[i] = vote;
        }

        int cnt = 0;

        while(true){
            int max = 0;
            int index = 0;
            for(int i = 1; i < n; i++){
                if(max < congressman[i]){
                    max = congressman[i];
                    index = i;
                }
            }

            if(max >= congressman[0]){
                congressman[0]++;
                congressman[index]--;
                cnt++;
            } else {
                break;
            }
        }

        System.out.println(cnt);
    }
}
