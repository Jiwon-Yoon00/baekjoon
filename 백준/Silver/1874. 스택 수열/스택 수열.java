import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();
        int num = 1;
        stack.push(num++);
        sb.append("+").append("\n");
        for (int i = 0; i < n; i++) {
            if(!stack.isEmpty() && arr[i] < stack.peek() ){
                System.out.println("NO");
                break;
            }

            while(true){

                if(!stack.isEmpty() && arr[i] == stack.peek()){
                    stack.pop();
                    sb.append("-").append("\n");
                    break;
                }else {
                    stack.push(num++);
                    sb.append("+").append("\n");
                }
            }
        }
        if(stack.isEmpty()){
            System.out.println(sb);
        }
    }
}