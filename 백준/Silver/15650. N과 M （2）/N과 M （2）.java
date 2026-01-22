import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int N;
    static int M;
    static StringBuilder sb;
    static boolean[] visited;
    static int[] result;
    static boolean[] arr;
    static int cnt = 1;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        arr = new boolean[N+1];
        result = new int[M];
        
        dfs(0, 1);
        
        
        System.out.println(sb);
    }

    static void dfs(int depth, int start){
      if(depth == M){
          for (int i = 0; i < M; i++) {
                sb.append(result[i]).append(" ");
                //System.out.println("$ " + result[i] + " ");
             
            }
            sb.append("\n");
            return;
      }

        for(int i = start; i <= N; i ++){
            result[depth] = i;
            dfs(depth + 1, i + 1);
        }
    }
}