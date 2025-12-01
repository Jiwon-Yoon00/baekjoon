import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(br.readLine());
        
        
        for(int c = 0; c < test_case; c++){
            ArrayDeque<int[]> q = new ArrayDeque<>();
            String[] line = br.readLine().split(" ");
            int N = Integer.parseInt(line[0]);
            int M = Integer.parseInt(line[1]);
            int cnt = 0;
            String[] pri = br.readLine().split(" ");

            Integer[] priList = new Integer[N];
            for(int i = 0; i < N; i ++) {
                priList[i] = Integer.parseInt(pri[i]);
                q.offer(new int[]{i, Integer.parseInt(pri[i])});      
            }
            Arrays.sort(priList, Collections.reverseOrder());
            int x = 0;
            while(!q.isEmpty()){
                int[] cur = q.peek();
                int index = cur[0];
                int priority = cur[1];

                if(priority < priList[x]){
                    q.offer(q.poll());
                    //System.out.println("index: " + index + " pri:" + priority);
                    
                }else if(priority == priList[x]){
                    //System.out.println("% index: " + index + " pri:" + priority);
                    q.remove();
                    x++;
                    cnt++;
                    if(index == M)break;
                }
            }
            System.out.println(cnt);
        }
    }
}