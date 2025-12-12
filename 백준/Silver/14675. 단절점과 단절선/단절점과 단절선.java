import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());        
        List<Integer>[] list = new ArrayList[N+1];

        for(int i = 0; i <= N; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < N-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        int q = Integer.parseInt(br.readLine());   

        for(int i = 0; i < q; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            if(t == 1){
                if(list[k].size() > 1){
                    sb.append("yes").append("\n");   
                }else{
                    sb.append("no").append("\n");   
                }
            }else{
                sb.append("yes").append("\n");   
            }
            
        }

        System.out.println(sb);
        
    }
}