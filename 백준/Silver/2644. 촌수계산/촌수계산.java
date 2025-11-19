

import java.util.*;
import java.io.*;

class Main
{
	static int N;
	static int x;
	static int y;
	static int cnt;
	static int result;
	static List<Integer>[] graph;
	static boolean[] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		visited = new boolean[N+1];
		
		String[] line = br.readLine().split(" ");
		x = Integer.parseInt(line[0]);
		y = Integer.parseInt(line[1]);
		
		int M = Integer.parseInt(br.readLine());
		
		graph = new ArrayList[N + 1];
		for(int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		// 인접리스트  입력
		for(int i = 0; i < M; i++) {
			String[] line2 = br.readLine().split(" ");
			int num1 = Integer.parseInt(line2[0]);
			int num2 = Integer.parseInt(line2[1]);
			graph[num1].add(num2);
			graph[num2].add(num1);
		}
		
		dfs(x, 0);
		
		System.out.println(result == 0 ? -1 : result);
		
	}
	public static void dfs(int start, int depth) {
		visited[start] = true;
		
		if(start == y) {
			result = depth;
			return;
		}
		
		for(int next: graph[start]) {
			if(!visited[next]) {
				dfs(next, depth+1);
			}
		}
		
	}
}