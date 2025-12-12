import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());        
        List<Integer>[] list = new ArrayList[N+1];
       
        for(int i = 1; i<= N; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i< N-1;i ++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a =Integer.parseInt(st.nextToken());
            int b =Integer.parseInt(st.nextToken());

            list[b].add(a);
            list[a].add(b);
        }
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[N+1];
        int[] parent = new int[N+1];

        q.add(1);
        visited[1] = true; 


        while(!q.isEmpty()){
            int cur = q.poll();

            for(int next: list[cur]){
                if(visited[next]) continue;
                visited[next] = true;
                q.add(next);
                parent[next] = cur;
            }
        }

        for(int i = 2; i <= N; i++){
            sb.append(parent[i]).append("\n");
        }

        System.out.println(sb);
        
    }
}