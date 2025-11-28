import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int K = Integer.parseInt(line[1]);
        
        
        StringBuilder sb = new StringBuilder("<");
        ArrayDeque<Integer> q = new ArrayDeque<>();
        
        for(int c = 1; c <= N; c++){
            q.offer(c);
        }

        while(!q.isEmpty()){
          for(int i = 0; i < K- 1; i ++){
              q.offer(q.poll());
          }

            sb.append(q.poll());

            if(!q.isEmpty()) sb.append(", ");
        }
        sb.append(">");
        System.out.println(sb);
    }
}