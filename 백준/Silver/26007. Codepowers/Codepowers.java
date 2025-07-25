import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

		int[] arr = new int[N+1];
		int[] isLower = new int[N + 1];
		int[] prefix = new int[N+1];

		int cnt = 0;

		st = new StringTokenizer(br.readLine(), " ");
		arr[0] = X;
		for (int i = 1; i <= N; i++) {
			int diff = Integer.parseInt(st.nextToken());
			arr[i] = arr[i-1] + diff;
			isLower[i] = arr[i] < K ? 1: 0;
			prefix[i] = prefix[i-1] + isLower[i];
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int l =  Integer.parseInt(st.nextToken());
			int r =  Integer.parseInt(st.nextToken());

			sb.append(prefix[r - 1] - prefix[l - 1]).append('\n');
		}
		System.out.print(sb);
	}
}