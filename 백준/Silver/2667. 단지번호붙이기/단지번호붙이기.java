

import java.util.*;
import java.io.*;

class Main
{
	static int N;
	static int[][] arr;
	static boolean[][] visited;
	//static List<Integer>[] list;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int cnt;
	static int total;
	static String str = "";
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		//list = new ArrayList[N];
		arr = new int[N][N];
		visited = new boolean[N][N];
		
//		for(int i = 0; i < N; i ++) {
//			list[i] = new ArrayList<>();
//		}
		
		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			for(int j = 0; j < N; j++) {
				arr[i][j] = line.charAt(j) - '0';

			}
		}
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(arr[i][j] == 1 && !visited[i][j]) {
					cnt = 0;
					dfs(i,j);
					list.add(cnt);
				}
			}
		}
		
		
		System.out.println(list.size());
		Collections.sort(list);
		for(int v:list) System.out.println(v);
		
	}
	
	public static void dfs(int x, int y) {
		visited[x][y] = true;
		cnt++;
		
		for(int i = 0; i < 4; i ++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < 0 || ny < 0 || nx >=N || ny >= N) continue;
			if(!visited[nx][ny] && arr[nx][ny] == 1) {
	            dfs(nx, ny);
	        }

		}
		
	}
}