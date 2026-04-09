import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static int n, k;

    public static class CircleQueue {
        int[] queue;
        int front;
        int rear;
        int size;

        CircleQueue(int size) {
            queue = new int[size];
            front = rear = this.size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public void enqueue(int data) {
            queue[rear] = data;
            size++;
            rear = (rear + 1) % queue.length;
        }

        public int dequeue() {
            int result = queue[front];
            front = (front + 1) % queue.length;
            size--;
            return result;
        }

        public int size() {
            return size;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        CircleQueue q = new CircleQueue(n);

        for(int i = 1; i<=n;i++){
            q.enqueue(i);
        }

        List<Integer> resultList = new ArrayList<>();

        while(!q.isEmpty()){
            for(int i = 0; i<k-1;i++){
                q.enqueue(q.dequeue());
            }
            resultList.add(q.dequeue());
        }

        System.out.print("<");
        for(int i = 0; i<resultList.size();i++){
            System.out.print(resultList.get(i));
            if(i != resultList.size() - 1){
                System.out.print(", ");
            }
        }
        System.out.print(">");
    }
}
