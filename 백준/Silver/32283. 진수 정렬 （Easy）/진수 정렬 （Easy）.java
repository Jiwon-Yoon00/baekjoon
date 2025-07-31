import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	// 이진수 정렬 기준 클래스
	static class Binary implements Comparable<Binary> {
		String value;
		int ones;        // 1의 개수
		String reversed; // 뒤집은 문자열

		Binary(String value) {
			this.value = value;
			this.ones = countOnes(value);
			this.reversed = new StringBuilder(value).reverse().toString();
		}

		@Override
		public int compareTo(Binary o) {
			if (this.ones != o.ones) return Integer.compare(this.ones, o.ones);
			return this.reversed.compareTo(o.reversed);
		}

		private static int countOnes(String s) {
			int count = 0;
			for (char c : s.toCharArray()) {
				if (c == '1') count++;
			}
			return count;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		String S = br.readLine();

		List<Binary> list = new ArrayList<>();

		// 모든 길이 N짜리 이진수 생성
		for (int i = 0; i < (1 << N); i++) {
			String bin = String.format("%" + N + "s", Integer.toBinaryString(i)).replace(' ', '0');
			list.add(new Binary(bin));
		}

		// 정렬
		Collections.sort(list);

		// 위치 찾기
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).value.equals(S)) {
				System.out.println(i); // 위치는 0부터 시작
				return;
			}
		}
	}
}
