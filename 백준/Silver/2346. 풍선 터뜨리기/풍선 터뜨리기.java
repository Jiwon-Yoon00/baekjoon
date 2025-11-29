import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception {
        
        
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String line[] = br.readLine().split(" ");
        
        for(int i = 0; i < N; i++){
            deque.offer(new int[]{i + 1,Integer.parseInt(line[i])});
        }

int[] arr;
        int x;
        int y;
        int diret = 0;
       while(!deque.isEmpty()){
           if(diret == 0){
                arr = deque.poll();
                x = arr[0];
                y = arr[1];
           }else{
                arr = deque.removeLast();
                x = arr[0];
                y = arr[1];   
           }
            sb.append(x).append(" ");

           if(deque.isEmpty()) break;
            if(y > 0){
                 diret = 0;
                for(int j = 0; j < y-1 ; j++){
                    deque.offer(deque.remove());
                }   
            }else{
                diret = 1;
                for(int j = 0; j < (-y)-1 ; j++){
                   deque.offerFirst(deque.removeLast());
                }   
            }
        }
        
        System.out.println(sb);
    }
}