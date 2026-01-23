import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int N;
    static int[][] W;
    static boolean[] visited;
    static int[] result;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        result = new int[N];
        W = new int[N][N];
        
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited[0] = true;
        dfs(0,0,1);
        
        System.out.println(answer);
    }

    static void dfs(int cur, int cost, int count){
        if (cost >= answer) return;
        
        if (count == N) {
            if (W[cur][0] != 0) {
                answer = Math.min(answer, cost +W[cur][0]);
            }
            return;
        }

        for(int i = 0; i < N; i++){
            if(visited[i]) continue;
            if(W[cur][i] == 0) continue;
            
            visited[i] = true;

            dfs(i, cost + W[cur][i], count + 1);

            visited[i] = false;
        }
    }
}