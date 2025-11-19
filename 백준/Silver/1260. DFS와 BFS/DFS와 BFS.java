

import java.util.*;
import java.io.*;

class Main
{
	
	static int[][] arr;
	static boolean[] vistied;
	static int N;
	static int M;
	static StringBuilder sb;
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		int v = Integer.parseInt(str[2]);
		arr = new int[N+1][N+1];
		vistied = new boolean[N+1];
		for(int i = 0 ; i< M; i ++) {
			String[] vertex = br.readLine().split(" ");
			int x = Integer.parseInt(vertex[0]);
			int y = Integer.parseInt(vertex[1]);
			arr[x][y] = 1;
			arr[y][x] = 1;
		}
		
		sb = new StringBuilder();
		dfs(v);
		System.out.println(sb);
		sb = new StringBuilder();
		
		vistied = new boolean[N+1];
		bfs(v);
		System.out.println(sb);
	}
	
	public static void dfs(int start) {
		
		sb.append(start + " ");
		vistied[start] = true;
		
		for(int i = 1; i <= N; i ++ ) {
			if(vistied[i]== false  && arr[start][i] == 1) {
				dfs(i);
			}
		}
	}
	
	public static void bfs(int start) {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.offer(start);
		vistied[start] = true;
		
		while(!q.isEmpty()) {
			int x = q.poll();
			
			sb.append(x + " ");
			
			for(int i = 1; i <= N; i ++) {
				if(arr[x][i] == 1 && vistied[i] == false) {
					q.offer(i);
					vistied[i] = true;
				}
			}
		}
		
	}
}