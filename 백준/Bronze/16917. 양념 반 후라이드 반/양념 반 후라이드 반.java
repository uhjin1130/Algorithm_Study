import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int yang = Integer.parseInt(st.nextToken());
        int fried = Integer.parseInt(st.nextToken());
        int banban = Integer.parseInt(st.nextToken());
        int yangMin = Integer.parseInt(st.nextToken());
        int friedMin = Integer.parseInt(st.nextToken());

        int result = 0;

        if(yang+fried <= banban*2){
            result += yang*yangMin + fried*friedMin;
        } else{
            if(yangMin>friedMin){
                result += friedMin * 2 * banban;
                result += Math.min((yangMin-friedMin) * yang, (yangMin-friedMin) * 2 * banban);
            } else {
                result += yangMin * 2 * banban;
                result += Math.min((friedMin-yangMin) * fried, (friedMin-yangMin) * 2 * banban);
            }
        }

        System.out.println(result);

    }
}