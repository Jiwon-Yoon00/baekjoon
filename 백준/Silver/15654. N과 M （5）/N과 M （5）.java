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
    static int[] result;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        visited = new boolean[arr[arr.length-1] + 1];
        result = new int[M];
        
        dfs(0);
        
        System.out.println(sb);
    }

    static void dfs(int depth){
      if(depth == M){
          //System.out.println("##");
          for (int i = 0; i < M; i++) {
                sb.append(result[i]).append(" ");
               //System.out.println("##: "+ result[i]);
            }
            sb.append("\n");
            return;
      }

        for(int v : arr){
            //System.out.println("&&");
            if(visited[v]) continue;
            //System.out.println("@@");
            visited[v] = true;
            result[depth] = v;

            dfs(depth + 1);

            visited[v] = false;
        }
    }
}