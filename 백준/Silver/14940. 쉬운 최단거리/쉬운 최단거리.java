import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static int n;
    static int m;
    static int[][] arr;
    static int[][] dist;
    static int[] cx = {1, 0, -1, 0};
    static int[] cy = {0, 1, 0, -1};
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        dist = new int[n][m];
        
        int sx = -1, sy = -1;
        
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                dist[i][j] = -1;

                if (arr[i][j] == 0) dist[i][j] = 0; // 0 이면 0
                if (arr[i][j] == 2) { sx = i; sy = j; } // 시작점
            }
        }

        bfs(sx,sy);
 
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
        
    }

    static void bfs(int x, int y){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x,y});
        dist[x][y] = 0;

        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int i = 0; i < 4; i++){
                int dx = cur[0] + cx[i];
                int dy = cur[1] + cy[i];

                if(dx >= n || dy >= m || dx < 0 || dy < 0) continue;
                if (arr[dx][dy] == 0) continue; 
                if (dist[dx][dy] != -1) continue;
                
                q.add(new int[]{dx,dy});
                dist[dx][dy] = dist[cur[0]][cur[1]] + 1;
            }
        }
    }
}