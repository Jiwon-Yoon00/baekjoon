import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int N;
    static int M; 
    static int[] arr;
    static int[] result;
    
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        
        result = new int[M];
        
        dfs(0, 0);
    
        System.out.println(sb);
    }

    static void dfs(int depth, int start){
        if(depth == M){
            for(int i = 0; i < M; i++){
                sb.append(result[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i = start; i < N; i++){
            
            result[depth] = arr[i];
            dfs(depth + 1, i + 1);
        }
    }
}