import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[][] board = new char[7][7];

		for (int i = 0; i < 7; i++) {
			String line = br.readLine();
			for (int j = 0; j < 7; j++) {
				board[i][j] = line.charAt(j);
			}
		}

		// 이동 방향: 위, 아래, 왼쪽, 오른쪽
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};

		int count = 0;

		for (int x = 0; x < 7; x++) {
			for (int y = 0; y < 7; y++) {
				if (board[x][y] != 'o') continue;
				for (int d = 0; d < 4; d++) {
					int nx1 = x + dx[d];
					int ny1 = y + dy[d];
					int nx2 = x + 2*dx[d];
					int ny2 = y + 2*dy[d];

					if (nx2 < 0 || nx2 >= 7 || ny2 < 0 || ny2 >= 7) continue;
					if (board[nx1][ny1] == 'o' && board[nx2][ny2] == '.') {
						count++;
					}
				}
			}
		}

		System.out.println(count);
	}
}
