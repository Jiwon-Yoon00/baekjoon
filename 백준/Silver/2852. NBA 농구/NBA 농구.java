import java.io.*;
import java.util.*;

// 1팀과 2팀의 갯수 세기
// 1 갯수 = 2 갯수 같다면 동점이므로 이기고 있는 시간 카운트 X
// 갯수가 뭐든 하나 더 많아야 시간 카운트
// : 을 기준으로 나눔


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[][] events = new int[N][2];


		// 입력 받기
		for (int i = 0; i < N; i++) {
			String[] string = br.readLine().split(" ");
			int team =  Integer.parseInt(string[0]);
			int time = timeToMinute(string[1]);
			events[i][0] = team;
			events[i][1] = time;
		}

		int score1 = 0;
		int score2 = 0;
		int lead1 = 0;
		int lead2 = 0;
		int prevTime = 0;

		for (int i = 0; i < N; i++) {
			int team =  events[i][0];
			int curTime = events[i][1];

			if (score1 > score2) {
				lead1 += curTime - prevTime;
			} else if (score2 > score1) {
				lead2 += curTime - prevTime;
			}

			// 이번 득점 반영
			if (team == 1) {
				score1++;
			} else {
				score2++;
			}

			prevTime = curTime;
		}

		// 경기 종료까지 반영 (48분 = 2880초)
		int endTime = 48 * 60;
		if (score1 > score2) {
			lead1 += endTime - prevTime;
		} else if (score2 > score1) {
			lead2 += endTime - prevTime;
		}

		// 결과 출력
		System.out.println(minuteToString(lead1));
		System.out.println(minuteToString(lead2));
	}

	static int timeToMinute(String time){
		String[] parts = time.split(":");
		int minute = Integer.parseInt(parts[0]);
		int second = Integer.parseInt(parts[1]);

		return minute * 60 + second;
	}

	static String minuteToString(int time){
		int m = time / 60;
		int s = time % 60;
		return String.format("%02d:%02d", m, s);
	}
}
