import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int N;
    static int M; 
    static int[] arr;
    static int[] result;
    static boolean[] visited;
    
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        result = new int[M];
        visited = new boolean[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);

        dfs(0);
    
        System.out.println(sb);
    }

    static void dfs(int depth){
        if(depth == M){
            for(int i = 0; i < M; i++){
                sb.append(result[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for(int v : arr){
            
            result[depth] = v;
            dfs(depth + 1);
        }
    }
}