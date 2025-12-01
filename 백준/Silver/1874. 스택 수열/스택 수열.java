import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i ++){
            arr[i] = Integer.parseInt(br.readLine()); 
        }

        ArrayDeque<Integer> stack = new ArrayDeque<>();
       
        int x = 1;
        int index = 0;
        
        while(true){
            if(!stack.isEmpty() && stack.peek() == arr[index]){
                stack.pop();
                //System.out.println("-");
                sb.append("-").append("\n");
                index++;
            }else{
                stack.push(x);
                sb.append("+").append("\n");
                //System.out.println("+");
                x++;   
            }

            if(stack.isEmpty() && index == N){
                System.out.println(sb);
                break;
            }

            if(!stack.isEmpty() && stack.peek() > arr[index]){
                System.out.println("NO");
                break;
            }
        }
    }
}