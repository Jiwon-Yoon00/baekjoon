import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] A = new int[N + 1];
		int[] B = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}

		long totalA = 0, totalB = 0;
		for (int i = 1; i <= N; i++) {
			totalA += A[i];
			totalB += B[i];
		}

		// prefix[i] = 맨 위에서 i개 제거했을 때 제거되는 무게
		long[] prefixA = new long[N + 1];
		long[] prefixB = new long[N + 1];

		for (int i = 1; i <= N; i++) {
			prefixA[i] = prefixA[i - 1] + A[N - i + 1];
			prefixB[i] = prefixB[i - 1] + B[N - i + 1];
		}

		long ans = Long.MAX_VALUE;

		// 투포인터
		int j = Math.min(N, K);
		for (int i = 0; i <= Math.min(N, K); i++) {
			while (j > 0 && i + j > K) j--; 

			if (i + j > K) continue; 

			long weightA = totalA - prefixA[i];
			long weightB = totalB - prefixB[j];
			long res = Math.max(weightA, weightB);
			ans = Math.min(ans, res);
		}

		bw.write(ans + "\n");
		bw.flush();
	}
}
