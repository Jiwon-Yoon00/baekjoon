import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		long[] v = new long[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			v[i] = Long.parseLong(st.nextToken());
		}

		long s = v[n - 1];  // 마지막 구간 속도
		for (int i = n - 2; i >= 0; i--) {
			long vi = v[i];
			s = ((s + vi - 1) / vi) * vi;
		}

		System.out.println(s);
	}
}
