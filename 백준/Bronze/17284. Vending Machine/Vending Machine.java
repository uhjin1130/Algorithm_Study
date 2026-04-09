import java.io.*;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] num = br.readLine().split(" ");

        int[] cost = { 500, 800, 1000};
        int money = 5000;
        
        for(int i = 0; i < num.length; i++){
            int btn = Integer.parseInt(num[i]) - 1;
            money-=cost[btn];
        }
        System.out.println(money);
    }

}