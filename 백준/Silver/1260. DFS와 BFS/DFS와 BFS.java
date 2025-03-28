import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static int N;
    static int M;
    static int V;
    static int[][] Graph;  // 그래프를 표현할 2D 배열
    static LinkedList<Integer>[] graph;
    static Queue<Integer> queue = new LinkedList<>();
    static boolean[] Visited;  // 각 노드의 방문 여부를 저장할 배열
    public static void main(String[] args) throws NumberFormatException, IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        Graph = new int[N+1][N+1];
        Visited = new boolean[N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            Graph[u][v] = Graph[v][u] = 1;
        }

        dfs(V);
        Visited = new boolean[N+1];
        System.out.println();
        bfs(V);
    }

    public static void dfs(int v){
        Visited[v] = true;
        System.out.print(v +" ");
        for (int i = 1; i <= N; i++) {
            if(!Visited[i] && Graph[v][i] != 0){
                dfs(i);
            }
        }
    }

    public static void bfs(int v){
        queue.add(v);
        Visited[v] = true;
        while (!queue.isEmpty()){
            int temp = queue.poll();
            System.out.print(temp + " ");

            for (int i = 1; i <= N; i++) {
                if(!Visited[i] && Graph[temp][i] != 0){
                    queue.add(i);
                    Visited[i] = true;
                }

            }
        }
    }


}