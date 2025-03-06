import java.util.Arrays;
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

        Stack stack = new Stack();
        int num = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String str = st.nextToken();
            if(st.hasMoreTokens()){
                num = Integer.parseInt(st.nextToken());
            }

            if(str.equals("push")){
                stack.push(num);
            }
            if(str.equals("pop")){
                sb.append(stack.pop()).append('\n');
            }
            if(str.equals("top")){
                sb.append(stack.top()).append('\n');
            }
            if(str.equals("size")){
                sb.append(stack.size()).append('\n');
            }
            if(str.equals("empty")){
                sb.append(stack.isEmpty()).append('\n');
            }
        }

        System.out.println(sb);

    }

    static class Stack{
        int top;
        int size;
        int []stack;
        public Stack() {
            this.size = 100000;
            stack = new int[size];
            top = -1;
        }

        public void push(int item){
            stack[++top] = item;
        }

        public int pop(){
            if(top == -1){
                return  -1;
            }
            int pop = stack[top];
            stack[top--] = 0;
            return pop;
        }

        public int size(){
            return top+1;
        }

        public int isEmpty(){
            if(top == -1){
                return 1;
            }else return 0;
        }

        public int top(){
            if(top == -1){
                return -1;
            }
            int peek = stack[top];
            return peek;
        }

    }
}