import java.util.*;
import java.io.*;

class Main
{
	static int[][] dist;
	static int[][] arr;
	static int N;
	static int M;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		sc.nextLine();
		arr = new int[N][M];
		dist = new int[N][M];
		
		// 입력받기
		for(int i= 0; i < N; i++) {
			String line = sc.nextLine(); 
			for(int j = 0; j < M; j++){
				arr[i][j] = line.charAt(j) - '0';
				dist[i][j] = Integer.MAX_VALUE;
			}
		}
		
		bfs();
		System.out.println(dist[N-1][M-1] +1);
		
	}
	
	public static void bfs() {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.add(new int[] {0,0});
		dist[0][0] = 0;
		while(!q.isEmpty()) {
			
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];
			
			for(int i = 0; i < 4; i ++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= M || arr[nx][ny] == 0) continue;
				
				int cost = arr[nx][ny] + dist[x][y];
				
				if(cost < dist[nx][ny]) {
					dist[nx][ny] = cost;
					q.add(new int[] {nx,ny});
				}
			}
			
			
			
		}
	}
}