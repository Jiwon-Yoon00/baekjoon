import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static int n;
    static int m;
    static int[] dist;
    static int MAX = 100000;
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dist = new int[MAX + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
    
        bfs(n);

        System.out.println(dist[m]);
    }

    static void bfs(int x){
        Deque<Integer> q = new ArrayDeque<>();
        q.add(x);
        dist[x] = 0;

        while(!q.isEmpty()){
            int cur = q.poll();

            if(cur == m) break;

            int[] nexts = {cur * 2, cur - 1, cur + 1};
            int[] costs = {0 ,1 ,1};

            for(int i = 0; i < 3; i++){
                int next = nexts[i];
                int cost = costs[i];

                if(next < 0 || next > MAX) continue;
                if(dist[next] > dist[cur] + cost){
                    dist[next] = dist[cur] + cost;
                    if(cost == 0) q.addFirst(next);
                    else q.addLast(next);
                }
            }
        }
    }
}