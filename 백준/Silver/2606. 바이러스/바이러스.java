import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int cnt = 0;
    static int computer;
    static int[][] graph;
    static boolean[] visitied;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        computer = Integer.parseInt(br.readLine());
        int pair = Integer.parseInt(br.readLine());
        
        graph = new int[computer + 1][computer + 1];
        visitied = new boolean[computer + 1];
        
        for(int i = 0; i < pair; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = graph[b][a] = 1;
        }

        dfs(1);
        System.out.println(cnt);
       
    }

    static void dfs(int num){
        visitied[num] = true;
        
        for(int i = 1; i < computer + 1; i++){
            if(!visitied[i] && graph[num][i] == 1){
                cnt++;
                dfs(i);
            }
        }
    }
}