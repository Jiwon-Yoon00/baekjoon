import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int[] computers;
    static Map<Integer, List<Integer>> map;
    static List<List<Integer>> list;
    static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        computers = new int[N+1];
        map = new HashMap<>();
        list = new ArrayList<>();
        for(int i = 0; i <= N; i++) list.add(new ArrayList<>());
        Set<Integer> startNodes = new HashSet<>();
        for(int i = 0 ; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(b).add(a);
             startNodes.add(b);
        }

        for (int v : startNodes) {
            bfs(v);
        }

        int maxCount = 0;
        for (int i = 1; i <= N; i++) {
            if (computers[i] > maxCount) maxCount = computers[i];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (computers[i] == maxCount) {
                sb.append(i).append(' ');
            }
        }
        System.out.println(sb.toString().trim());
    }

    static void bfs(int v){
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[N + 1];
        visited[v] = true;
        q.add(v);
        int cnt = 0;
        
        while(!q.isEmpty()){
            int cur = q.poll();
           // System.out.println("cur: " + cur);
            for(int next : list.get(cur)){
                //System.out.println("next: " + next);
                if(!visited[next]){
                    //System.out.println("!visited[cur]");
                    visited[next] = true;
                    q.add(next);
                    cnt++;   
                }
            }
        }

        computers[v] = cnt;
       // System.out.println("cnt: " + cnt);
    }
}