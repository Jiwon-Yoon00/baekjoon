import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = {2 ,2, -2, -2, 1, 1, -1, -1};
	static int[] dy = {1, -1, 1, -1, 2, -2, 2, -2};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//현재 위치
		StringTokenizer st = new StringTokenizer(br.readLine());
		int cx = Integer.parseInt(st.nextToken());
		int cy = Integer.parseInt(st.nextToken());

		// 목적지
		st = new StringTokenizer(br.readLine());
		int dx = Integer.parseInt(st.nextToken());
		int dy = Integer.parseInt(st.nextToken());

		int cnt = BFS(cx,cy, dx, dy);

		System.out.println(cnt);
	}

	static int BFS(int startX, int startY, int destinationX, int destinationY) {
		boolean[][] visited = new boolean[9][9];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {startX, startY});
		visited[startX][startY] = true;

		int depth = 0;

		while(!q.isEmpty()) {
			int size = q.size();
			for(int i = 0; i < size; i++) {
				int[] c = q.poll();
				int x =  c[0];
				int y = c[1];

				if (x == destinationX && y == destinationY) {
					return depth;
				}

				for (int j = 0; j < 8; j++) {
					int nx = x + dx[j];
					int ny = y + dy[j];

					if(nx < 1 || ny < 1 || nx > 8 || ny > 8){
						continue;
					}

					if (visited[nx][ny]) continue;

					visited[nx][ny] = true;
					q.add(new int[] {nx, ny});
				}
			}
			depth++;
		}
		return 0;
	}
}
