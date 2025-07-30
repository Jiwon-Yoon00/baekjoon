import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		// 1. 화살표 길이 1인 경우: -x > 0
		if (n == 1) {
			if (x < 0) {
				System.out.println("INFINITE");
			} else if (-x > 0) {
				System.out.println("1");
			} else {
				System.out.println("0");
			}
			return;
		}

		// 1. 화살표 길이(N)가 홀수이면 컴파일 에러
		if (n % 2 == 1) {
			System.out.println("ERROR");
			return;
		}

		// 2. 감소 횟수는 N / 2
		int step = n / 2;

		// 3. step이 0인데 x > 0이면 줄어들지 않으므로 무한 루프
		if (step == 0 && x > 0) {
			System.out.println("INFINITE");
			return;
		}

		// 4. 시뮬레이션 시작
		int result = 0;
		while (true) {
			x -= step;
			if (x <= 0) break;
			result++;
		}

		System.out.println(result);
	}
}