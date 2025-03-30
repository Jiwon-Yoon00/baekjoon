import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static int N;
    static int M;
    static int link = 0;
    static boolean[] visited;
    static int[][] graph;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        graph = new int[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u][v] = graph[v][u] = 1;
        }


        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (!visited[i] && graph[i][j] == 1){
                    dfs(i);
                    link++;
                }
            }
        }
        if(M == 0){
            System.out.println(N);
        }else {
            for (int i = 1; i < N+1; i++) {
                if(visited[i] == false){
                    link++;
                }
            }
            System.out.println(link);
        }
    }

    static void dfs(int i){
        visited[i] = true;

        for (int j = 1; j <= N; j++) {
                if(!visited[j] && graph[i][j] == 1){
                    dfs(j);
            }
        }
    }
}