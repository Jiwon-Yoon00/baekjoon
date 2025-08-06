import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		int left = 0;
		int maxLen = 0;

		// 입력받기
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		TreeMap<Integer, Integer> map = new TreeMap<>();
		for (int i = 0; i < N; i++) {

			// 왼쪽 값 추가
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);

			// 조건 위반
			while(map.lastKey() - map.firstKey() > 2) {
				int count = map.get(arr[left]);
				if (count == 1)
					map.remove(arr[left]);
				else
					map.put(arr[left], count - 1);
				left++;

			}
			maxLen = Math.max(maxLen,  i - left + 1);
		}
		System.out.println(maxLen);
	}
}
