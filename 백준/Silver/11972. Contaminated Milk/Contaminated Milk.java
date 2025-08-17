import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 사람
		int M = Integer.parseInt(st.nextToken()); // 우유 가짓수
		int D = Integer.parseInt(st.nextToken()); // 경우의 수
		int S = Integer.parseInt(st.nextToken()); // 아픈 사람?

		int[][] arr = new int[D][3];
		// 입력받기
		for (int i = 0; i < D; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				arr[i][j] =Integer.parseInt(st.nextToken());
			}
		}

		int[][] sick = new int[S][2];
		// 입력받기
		for (int i = 0; i < S; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				sick[i][j] =Integer.parseInt(st.nextToken());
			}
		}


		int max = 0;
		
		for(int m = 1; m <= M; m++){
			Set<Integer> drank = new HashSet<>(); // 해당 우유를 마신 사람들

			for(int d = 0; d < D; d++){
				if(arr[d][1] == m){
					drank.add(arr[d][0]);
					//System.out.println(m + "번 우유를 먹은 사람: " + arr[d][0]);
				}
			}

			boolean ok = true;
			for(int s = 0; s < S; s++){
				int person = sick[s][0];
				int sickTime = sick[s][1];
				boolean drankBefore = false;

				for(int d = 0; d < D; d++){
					if(arr[d][0] == person && arr[d][1] == m && arr[d][2] < sickTime){
						// 아픈 사람에 속하고, 아프기 전에 해당 우유를 먹었는지
						drankBefore = true;
						break;
					}
				}

				if(!drankBefore){
					ok = false;
					break;
				}
			}

			if(ok){
				max = Math.max(max, drank.size());
			}

			//System.out.println("필요한 약의 갯수: " + doses);
		}
		System.out.println(max);

	}
}
