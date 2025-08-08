import java.io.*;
import java.util.*;

public class Main {
	static final int INIT = 500; // 초깃값
	static int N, K, res = 0;
	static int[] arr;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		res = 0; // 경우의 수

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		visited = new boolean[N];
		arr =  new int[N];

		st = new StringTokenizer(br.readLine());
		// 입력받기
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		dfs(0, INIT);

		System.out.println(res);
	}

	static void dfs(int day, int weight){
		if(day == N){ // N일 모두 성공했다면
			res++;
			return;
		}

		for(int i = 0; i < N; i++){
			if(visited[i]) continue;

			int nextWeight = weight + arr[i] - K;
			if(nextWeight < INIT) continue;

			visited[i] = true;
			dfs(day + 1, nextWeight);
			visited[i] = false;
		}
	}
}
