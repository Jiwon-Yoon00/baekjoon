import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int offset = 0; // 시작 위치

		for (int q = 0; q < Q; q++) {
			st = new StringTokenizer(br.readLine());
			int type = Integer.parseInt(st.nextToken());

			if (type == 1) { // 1 i x: arr[i] += x
				int i = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int idx = (offset + i - 1) % N; // 실제 배열 인덱스 계산
				arr[idx] += x;
			} else if (type == 2) { 
				int s = Integer.parseInt(st.nextToken());
				offset = (offset - s + N) % N;
			} else {
				int s = Integer.parseInt(st.nextToken());
				offset = (offset + s) % N;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(arr[(offset + i) % N]).append(' ');
		}

		System.out.println(sb.toString().trim());
	}
}
