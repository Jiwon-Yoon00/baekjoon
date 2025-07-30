import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = {1, -1, 0, 0, 1, 1, -1, -1 };
	static int[] dy = {0, 0, 1, -1, 1, -1, 1, -1};
	static boolean[][] visited;
	static char[][] graph;
	static int n, m, cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		graph =  new char[n][m];
		visited = new boolean[n][m];

		// 입력받기
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for(int j = 0; j < m; j++) {
				graph[i][j] = str.charAt(j);
			}
		}

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(graph[i][j] == 'E' || graph[i][j] == 'I') {
					dfs(i, j);
				}
			}
		}

		System.out.println(cnt);

	}

	static void dfs(int x, int y){
		visited[x][y] = true;
		int cx, cy = 0;

		for(int i = 0; i < dx.length; i++) {
			cx = x + dx[i];
			cy = y + dy[i];

			if(cx >= 0 && cx < n && cy >= 0 && cy < m) {
				if(graph[cx][cy] == 'N' || graph[cx][cy] =='S') {
					cx = cx + dx[i];
					cy = cy + dy[i];

					if(cx >= 0 && cx < n && cy >= 0 && cy < m){
						if(graph[cx][cy] == 'F' || graph[cx][cy] =='T'){
							cx = cx + dx[i];
							cy = cy + dy[i];

							if(cx >= 0 && cx < n && cy >= 0 && cy < m) {
								if(graph[cx][cy] == 'J' || graph[cx][cy] =='P'){
									cnt++;
								}
							}
						}
					}
				}
			}
		}

	}
}