import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int answer;
	static boolean[][] visited;
	static int[][] graph;
	static int[][] dist;
	static int[] dx = { 0, -1, 0, 1, -1, 1, -1, 1 };
	static int[] dy = { 1, 0, -1, 0, 1, 1, -1, -1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N][M];
		dist = new int[N][M];
		graph = new int[N][M];

		Queue<int[]> q = new LinkedList<>();

		// 입력받기
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				if(graph[i][j] == 1){
					q.add(new int[] { i, j });
					visited[i][j] = true;
				}
			}
		}

		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int x = curr[0];
			int y = curr[1];

			for (int k = 0; k < 8; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];

				if(nx < 0 || ny < 0 || nx >= N || ny >= M ) continue; // nx, ny의 범위

				if(visited[nx][ny]) continue; // 방문한 적이 있으면 pass

				dist[nx][ny] = dist[x][y] + 1;
				visited[nx][ny] = true;
				q.offer(new int[] {nx, ny});
			}

		}
		int maxDist = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				maxDist = Math.max(maxDist, dist[i][j]);
			}
		}

		System.out.println(maxDist);
	}

}