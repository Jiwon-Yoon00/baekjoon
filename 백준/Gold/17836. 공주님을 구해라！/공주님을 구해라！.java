import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int N;
    static int M;
    static int T;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] dist;
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        T = Integer.parseInt(line[2]);
        dist = new int[N][M];
        arr = new int[N][M];
        visited = new boolean[N][M];

        int gramX = 0;
        int gramY = 0;
        for(int i = 0; i < N; i++){
            String[] parts = br.readLine().split(" ");
            for(int j = 0; j < M; j++){
                arr[i][j] = Integer.parseInt(parts[j]);
                if(arr[i][j] == 2){
                    gramX = i;
                    gramY = j;
                }
            }
        }
        
        dist[0][0] = 1;
        bfs(0,0);

        int orange = 0;
        if(dist[N-1][M-1] == 0){
            orange = Integer.MAX_VALUE;
        } else {
            orange = dist[N-1][M-1] - 1;
        }

        int green = Integer.MAX_VALUE;
        if(dist[gramX][gramY] != 0){
            green = dist[gramX][gramY] - 1
                  + (N - 1 - gramX)
                  + (M - 1 - gramY);
        }

        int min = Math.min(orange, green);
        
        if(min <= T) System.out.println(min);
        else System.out.println("Fail");
    }

    static void bfs(int x, int y){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x,y});
        visited[x][y] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int a = cur[0];
            int b = cur[1];

            for(int i =0; i< 4; i++){
                int cx = a + dx[i];
                int cy = b + dy[i];

                if(cx < 0 || cy < 0 || cx >= N || cy >= M) continue;
                if(visited[cx][cy]) continue;
                if(arr[cx][cy] == 1) continue;

                dist[cx][cy] = dist[a][b] + 1;
                visited[cx][cy] = true;
                q.add(new int[]{cx,cy});
            }
        }
    }
}