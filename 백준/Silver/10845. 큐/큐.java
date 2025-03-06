import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        Queue q = new Queue(N);
        int num = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String str = st.nextToken();
            if(st.hasMoreTokens()){
                num = Integer.parseInt(st.nextToken());
            }

            if(str.equals("push")){
                q.push(num);
            }
            if(str.equals("pop")){
                sb.append(q.pop()).append('\n');
            }
            if(str.equals("size")){
                sb.append(q.size()).append('\n');
            }
            if(str.equals("empty")){
                sb.append(q.isEmpty()).append('\n');
            }
            if(str.equals("front")){
                sb.append(q.front()).append('\n');
            }
            if(str.equals("back")){
                sb.append(q.back()).append('\n');
            }
        }

        System.out.println(sb);

    }

    static class Queue{
        int front;
        int rear;
        int size;
        int []q;
        public Queue(int size) {
            this.size = size;
            q = new int[size];
            front = rear = 0;
        }

        public void push(int item){
            q[rear++] = item;
        }

        public int pop(){
            if(isEmpty() == 1) return -1;
            int x = q[front++];
            return x;
        }

        public int size(){
            return rear-front;
        }

        public int isEmpty(){
            if(front == rear){
                return 1;
            }else return 0;
        }

        public int front(){
            if(isEmpty() == 1){
                return -1;
            }
            int peek = q[front];
            return peek;
        }

        public int back(){
            if(isEmpty()==1){
                return -1;
            }
            int peek = q[rear-1];
            return peek;
        }

    }
}


