import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 문자열 길이
		char[] P = br.readLine().toCharArray();
		char[] Q = br.readLine().toCharArray();
		char[] R = br.readLine().toCharArray();

		// H, J, S 각각 1~9 서로 다른 값으로 대입
		for (int h = 1; h <= 9; h++) {
			for (int j = 1; j <= 9; j++) {
				if (j == h) continue;
				for (int s = 1; s <= 9; s++) {
					if (s == h || s == j) continue;

					char[] map = new char[256];
					map['H'] = (char)('0' + h);
					map['J'] = (char)('0' + j);
					map['S'] = (char)('0' + s);

					// 변환된 문자열 생성
					StringBuilder pStr = new StringBuilder();
					StringBuilder qStr = new StringBuilder();
					StringBuilder rStr = new StringBuilder();

					for (int i = 0; i < N; i++) {
						pStr.append(map[P[i]]);
						qStr.append(map[Q[i]]);
						rStr.append(map[R[i]]);
					}

					// 문자열 비교
					String pVal = pStr.toString();
					String qVal = qStr.toString();
					String rVal = rStr.toString();

					if (pVal.compareTo(qVal) < 0 && qVal.compareTo(rVal) < 0) {
						System.out.println("HJS! HJS! HJS!");
						return;
					}
				}
			}
		}

		System.out.println("Hmm...");
	}
}
