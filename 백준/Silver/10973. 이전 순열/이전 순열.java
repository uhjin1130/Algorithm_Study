import java.io.*;
import java.util.*;

public class Main {
    public static int[] arr;
    public static int N;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for(int i = 0 ; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if(beforeArr()){
            for(int i : arr){
                sb.append(i + " ");
            }
        } else {
            sb.append(-1);
        }

        System.out.println(sb.toString());

    }

    public static boolean beforeArr(){
        int i = arr.length - 1;
        while(i > 0 && arr[i] > arr[i-1]) {
            i--;
        }

        if(i <= 0)
            return false;

        int j = arr.length - 1;
        while(arr[i-1] < arr[j]){
            j--;
        }

        int temp = arr[i-1];
        arr[i-1] = arr[j];
        arr[j] = temp;

        j = arr.length-1;
        while(i < j) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            i++;
            j--;
        }

        return true;
    }
}