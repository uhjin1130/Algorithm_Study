import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int total = 0;

        int getscore = -1;

        for(int i = 0; i < 5; i++){
            getscore= Integer.parseInt(br.readLine());
            if(getscore<40){
                total+=40;
            } else
                total+=getscore;
        }

        total = total/5;
        System.out.println(total);

    }
}