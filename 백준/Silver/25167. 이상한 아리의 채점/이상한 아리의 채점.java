import java.io.*;
import java.util.*;

public class Main {

	static class Attempt {
		String firstWrongTime = null;
		String solveTime = null;
		boolean solved = false;
		boolean invalid = false;
	}

	static class Participant {
		String name;
		Map<Integer, Attempt> attempts = new HashMap<>();
		int totalScore = 0;

		Participant(String name) {
			this.name = name;
		}
	}

	static int timeToMinutes(String time) {
		String[] parts = time.split(":");
		return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 문제 수
		int M = Integer.parseInt(st.nextToken()); // 참가자 수
		int P = Integer.parseInt(st.nextToken()); // 제출 기록 수

		Map<String, Participant> participants = new HashMap<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			String name = st.nextToken();
			participants.put(name, new Participant(name));
		}

		for (int i = 0; i < P; i++) {
			st = new StringTokenizer(br.readLine());
			int problem = Integer.parseInt(st.nextToken());
			String time = st.nextToken();
			String name = st.nextToken();
			String status = st.nextToken();

			Participant user = participants.get(name);
			Attempt attempt = user.attempts.getOrDefault(problem, new Attempt());

			if (attempt.solved) continue; // solve 이후 제출은 무시

			if (status.equals("wrong")) {
				if (attempt.firstWrongTime == null) {
					attempt.firstWrongTime = time;
				}
			} else if (status.equals("solve")) {
				if (attempt.firstWrongTime == null) {
					attempt.invalid = true; // wrong 없이 solve
				}
				attempt.solved = true;
				attempt.solveTime = time;
			}
			user.attempts.put(problem, attempt);
		}

		// 문제별로 점수 부여
		for (int prob = 1; prob <= N; prob++) {
			List<Participant> solvedList = new ArrayList<>();

			for (Participant p : participants.values()) {
				Attempt a = p.attempts.get(prob);
				if (a != null && a.solved && !a.invalid) {
					solvedList.add(p);
				}
			}

			// 정렬: 걸린 시간 오름차순, 이름순
			int finalProb = prob;
			solvedList.sort((p1, p2) -> {
				Attempt a1 = p1.attempts.get(finalProb);
				Attempt a2 = p2.attempts.get(finalProb);
				int t1 = timeToMinutes(a1.solveTime) - timeToMinutes(a1.firstWrongTime);
				int t2 = timeToMinutes(a2.solveTime) - timeToMinutes(a2.firstWrongTime);
				if (t1 != t2) return t1 - t2;
				return p1.name.compareTo(p2.name);
			});

			Set<String> awarded = new HashSet<>();
			int rank = 1;
			for (Participant p : solvedList) {
				p.totalScore += rank++;
				awarded.add(p.name);
			}

			for (Participant p : participants.values()) {
				if (awarded.contains(p.name)) continue;
				Attempt a = p.attempts.get(prob);
				if (a == null) {
					p.totalScore += M + 1; // 제출 없음
				} else if (!a.solved) {
					p.totalScore += M;     // 틀리고 못 푼 경우
				} else if (a.invalid) {
					p.totalScore += M + 1; // wrong 없이 solve
				}
			}
		}

		List<Participant> resultList = new ArrayList<>(participants.values());
		resultList.sort((p1, p2) -> {
			if (p1.totalScore != p2.totalScore) return p1.totalScore - p2.totalScore;
			return p1.name.compareTo(p2.name);
		});

		for (Participant p : resultList) {
			System.out.println(p.name);
		}
	}
}
