import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String st = bf.readLine();

        if(st.equals("SONGDO"))
            System.out.println("HIGHSCHOOL");
        else if (st.equals("CODE"))
            System.out.println("MASTER");
        else if (st.equals("ALGORITHM"))
            System.out.println("CONTEST");
        else if (st.equals("2023"))
            System.out.println("0611");
    }
}