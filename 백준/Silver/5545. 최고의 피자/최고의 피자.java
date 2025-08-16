import java.io.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Integer[] toKalc =  new Integer[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		int A =  Integer.parseInt(st.nextToken()); // 도우의 가격
		int B = Integer.parseInt(st.nextToken()); // 토핑의 가격
		int C = Integer.parseInt(br.readLine()); // 도우의 열량

		// 토핑의 열량
		for (int i = 0; i < N; i++) {
			toKalc[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(toKalc, Collections.reverseOrder()); // 정렬


		int totalPrice = A;
		int totalKalc = C;
		int maxPrice = 0;

		for (int i = 0; i <= N; i++) {

			if(i != 0){
				totalPrice += B;
				totalKalc += toKalc[i-1];
			}
			int curPrice = totalKalc / totalPrice; // 1원 당 가격 계산

			if(maxPrice < curPrice){
				//System.out.println("최고 높은 열량: " + maxPrice + " 현재 열량: " + curPrice);
				maxPrice = curPrice;
			}
		}

		System.out.println(maxPrice);

	}
}
