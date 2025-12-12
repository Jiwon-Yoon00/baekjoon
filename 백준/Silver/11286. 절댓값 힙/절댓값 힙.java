import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> q = new PriorityQueue<>(
            (a,b) -> {
                int absA = Math.abs(a);
                int absB = Math.abs(b);

                if(absA != absB){
                    return absA - absB;
                }
                return a-b;
            }
        );
        int N = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < N; i++){
            int x = Integer.parseInt(br.readLine());
            if(x == 0){
                if(q.isEmpty()){
                    sb.append(0).append("\n");
                }else{
                    sb.append(q.remove()).append("\n");
                }
            }else{
                q.add(x);
            }
        }

        System.out.println(sb);
        
    }
}