import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int N;
    static int S;
    static int[] arr;
    static boolean[] visited;
    static int[] map;
    static int result = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken()); 
        
        visited = new boolean[N+1];
        arr = new int[N];
        map = new int[N]; 
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
 if (S == 0) result--;
        dfs(0, 0);
        
        System.out.println(result);
    }

    static void dfs(int idx, int sum) {
        if (idx == N) {
            if (sum == S) result++;
            return;
        }
    
        // 현재 원소를 선택하는 경우
        dfs(idx + 1, sum + arr[idx]);
    
        // 현재 원소를 선택하지 않는 경우
        dfs(idx + 1, sum);
    }

}