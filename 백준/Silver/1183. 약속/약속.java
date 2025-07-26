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
		int[] waitTime = new int[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int arrival = Integer.parseInt(st.nextToken());
			int duration = Integer.parseInt(st.nextToken());
			waitTime[i] = arrival - duration;
		}

		Arrays.sort(waitTime);

		int count = 1;
		if (N % 2 == 0) {
			int left = waitTime[N / 2 - 1];
			int right = waitTime[N / 2];
			count = right - left + 1;
		}

		System.out.println(count);
	}
}