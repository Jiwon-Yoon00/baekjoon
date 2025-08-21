import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		while(T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int W = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());

			int[][] arr = new int[N][2];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}

			long total = 0;
			int curCapacity = 0; // 현재 트럭에 싣고 있는 쓰레기 양
			int lastPos = 0; // 마지막 위치

			for(int i = 0; i < N; i++) {


				int curDis = arr[i][0] - lastPos; // 현재 이동해야 하는 거리: 가야하는 쓰레기장 거리 - 이전에 들린 거리
				total += curDis;
				lastPos = arr[i][0];


				if((curCapacity + arr[i][1]) > W){ // 용량이 넘으면
					total += (lastPos * 2); // 그 거리만큼 다시 이동
					curCapacity = 0;
				}

				curCapacity += arr[i][1];

				if(curCapacity == W && i != N - 1){ // 용량이  같다면 바로 돌아가기
					total += (lastPos * 2);
					curCapacity = 0;

				}
			}

			if (curCapacity > 0) {
				total += lastPos;
			}

			System.out.println(total);
		}

	}
}
