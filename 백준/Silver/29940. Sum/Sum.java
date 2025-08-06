import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int total = 0;
		int[] arr = new int[N];

		int start = 0;
		int end = N-1;

		// 입력받기
		for(int i = 0; i < N; i++){
			arr[i] = Integer.parseInt(br.readLine());
		}

		//
		while (start < end) {
			int sum = arr[start] + arr[end];

			if (sum == S) {
				total++;
				start++;
				end--;
			} else if (sum < S) {
				start++;
			} else {
				end--;
			}
		}
		System.out.println(total);
	}
}
