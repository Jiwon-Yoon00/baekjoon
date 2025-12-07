import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();
        
        ArrayDeque<int[]> stack = new ArrayDeque<>();

        for(int i = 0; i < N; i++){
            int cur = Integer.parseInt(line[i]);

            while(!stack.isEmpty() && stack.peek()[0] < cur){
                stack.pop();
            }

            if(stack.isEmpty()){
                sb.append(0);
            }else{
                sb.append(stack.peek()[1]);
            }

            if(i < N -1 ) sb.append(" ");

            stack.push(new int[]{cur, i+1});
        }
        System.out.print(sb);
    }
}