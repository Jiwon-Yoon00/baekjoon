import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		int[] waitTime = new int[N];
		int maxDiff = 0;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			waitTime[i] = arr[i][0] - arr[i][1];
		}

		Arrays.sort(waitTime);

		// 중앙값 구하기
		int median;
		if (N % 2 == 1) {
			median = -waitTime[N / 2];
		} else {
			median = -waitTime[N / 2 - 1]; // 중앙값이 여러 개일 경우, 최소/최대 범위 구분 필요
		}

		// 최소 비용 계산
		int minCost = 0;
		for (int wt : waitTime) {
			minCost += Math.abs(wt + median);
		}

		// 중앙값이 여러 개인 경우 최소 비용이 나오는 T의 개수를 세기
		int count = 1;
		if (N % 2 == 0) {
			int median1 = -waitTime[N / 2 - 1];
			int median2 = -waitTime[N / 2];
			count = Math.abs(median2 - median1) + 1; // 모든 정수 T 중 최소 비용이 나오는 개수
		}

		System.out.println(count);
	}
}