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
        int index = K;
        
        for(int c = 0; c < N; c++){
            if(N + 1 == index){
                index = 1;
            }
            q.offer(index % (N + 1));
            index++;
        }

        for(int i = 0; i < N; i++){
            if(i == N - 1){
                sb.append(q.poll()).append(">");
                break;
            }else{
                 sb.append(q.poll()).append(", "); 
            }

            for(int j = 0; j < K-1; j++){
                int v = q.poll();
                q.offer(v);
            }

        }

        System.out.println(sb);
    }
}