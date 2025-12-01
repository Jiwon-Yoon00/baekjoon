import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(br.readLine());
        
        
        while(test_case-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            
            st = new StringTokenizer(br.readLine());
            ArrayDeque<int[]> q = new ArrayDeque<>();
            int[] count = new int[10];

            
            for(int i = 0; i < N; i ++) {
                int p = Integer.parseInt(st.nextToken());
                q.offer(new int[]{i, p});
                count[p]++;
            }
            
            int printed = 0;
            for(int priority = 9; priority >= 1;){
                if(count[priority] == 0){
                    priority--;
                    continue;
                }

                int[] cur = q.poll();
                if(cur[1] == priority){
                    printed++;
                    count[priority]--;
                    if(cur[0] == M){
                       System.out.println(printed);
                        break;
                    }
                }else {
                    q.offer(cur);
                }
            }
        }
    }
}