import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] sorted = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sorted[i] = arr[i];
		}

		// 정렬된 배열
		Arrays.sort(sorted);

		// Bessie가 옮겨지면서 어긋난 부분 추출
		List<Integer> diffIndices = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			if (arr[i] != sorted[i]) {
				diffIndices.add(i);
			}
		}

		// Bessie 하나만 잘못된 위치에 있으므로
		// 이 작은 부분 배열을 정렬하는 데 필요한 스왑 수 계산
		int size = diffIndices.size();
		int[] temp = new int[size];
		for (int i = 0; i < size; i++) {
			temp[i] = arr[diffIndices.get(i)];
		}

		// 사이클 정렬: 최소 스왑 수 계산
		Integer[] indices = new Integer[size];
		for (int i = 0; i < size; i++) indices[i] = i;
		Arrays.sort(indices, Comparator.comparingInt(i -> temp[i]));

		boolean[] visited = new boolean[size];
		int swaps = 0;
		for (int i = 0; i < size; i++) {
			if (visited[i] || indices[i] == i) continue;
			int cycleSize = 0;
			int j = i;
			while (!visited[j]) {
				visited[j] = true;
				j = indices[j];
				cycleSize++;
			}
			swaps += (cycleSize - 1);
		}

		System.out.println(swaps);
	}
}
