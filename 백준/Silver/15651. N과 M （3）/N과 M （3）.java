import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int N;
    static int M;
    static StringBuilder sb;
    static boolean[] visited;
    static int[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        String[] line = br.readLine().split(" ");
        
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        visited = new boolean[N+1];
        arr = new int[M];
        dfs(0);
        
        System.out.println(sb);
    }

    static void dfs(int depth){
      if(depth == M){
          for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
      }

        for(int i = 1; i <= N; i++){
            
           
            arr[depth] = i;

            dfs(depth + 1);

            visited[i] = false;
        }
    }
}