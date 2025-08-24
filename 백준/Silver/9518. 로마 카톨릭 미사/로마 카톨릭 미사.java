import java.io.*;
import java.util.*;

public class Main {
	static int[] dx = {1, 0, 1, 1};         // 중복 방지용 (기존 악수 계산)
	static int[] dy = {0, 1, 1, -1};
	static int[] x = {1, 1, -1, -1 ,0 ,0, 1, -1};
	static int[] y = {0, 1, 0, -1, 1, -1, -1 , 1};
	static boolean[][] visited ;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());

		char[][] arr = new char[R][S];
		visited = new boolean[R][S];

		// 입력 받기
		for(int i = 0; i < R; i++) {
			String str =  br.readLine();

			for(int j = 0; j < S; j++) {
				arr[i][j] = str.charAt(j);
			}
		}

		int res = 0;
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < S; j++) {

				if(arr[i][j] == 'o') { // 일단 기존 자리에서 할 수 있는 악수 갯수를 세고
					for(int k = 0; k < dx.length; k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];
						if (nx >= 0 && nx < R && ny >= 0 && ny < S) {
							if (arr[nx][ny] == 'o') res++;
						}
					}
				}
			}
		}


		int max = 0;

		for(int i = 0; i < R; i++) {
			for(int j = 0; j < S; j++) {

				if(arr[i][j] == '.') { // 상근이가 자리에 앉았을 때 늘어나는 res 수
					int temp = 0;

					for(int k = 0; k < x.length; k++) {
						int cx = i + x[k];
						int cy = j + y[k];

						if (cx >= 0 && cx < R && cy >= 0 && cy < S) {
							if (arr[cx][cy] == 'o') temp++;
						}
					}
					max = Math.max(max, temp);
				}
			}
		}

		System.out.println(max + res);

	}
}
