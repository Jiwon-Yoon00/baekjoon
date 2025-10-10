import java.io.*;
import java.util.*;

class Main {
    static int n;                   // 공원/교실 크기
    static int[][] arr;             // 학생 자리 배열
    static Map<Integer, Set<Integer>> liked = new HashMap<>(); // 학생별 좋아하는 친구
    static int[] dx = { -1, 1, 0, 0 }; // 상하좌우 방향 벡터
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());           // 교실 크기 입력
        arr = new int[n][n];                           // 좌석 초기화

        int[] order = new int[n * n];                  // 학생 배치 순서 저장

        // 입력 처리: 학생 번호 + 좋아하는 친구 4명
        for (int i = 0; i < n * n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int student = Integer.parseInt(st.nextToken());
            order[i] = student;                         // 학생 순서 기록

            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < 4; j++) {
                set.add(Integer.parseInt(st.nextToken())); // 좋아하는 친구 저장
            }
            liked.put(student, set);
        }

        // 학생 배치
        for (int s = 0; s < n * n; s++) {
            placeStudent(order[s]);                     // 학생별 자리 배치
        }

        // 만족도 계산
        int totalScore = 0;
        for (int i = 0; i < n; i++) {                 // 모든 좌석 탐색
            for (int j = 0; j < n; j++) {
                int student = arr[i][j];              // 현재 학생 번호
                int cnt = 0;                           // 인접한 좋아하는 친구 수

                // 상하좌우 체크
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue; // 범위 벗어나면 패스
                    if (liked.get(student).contains(arr[nx][ny])) cnt++;   // 좋아하는 친구 발견
                }

                // 만족도 점수 계산
                if (cnt == 1) totalScore += 1;
                else if (cnt == 2) totalScore += 10;
                else if (cnt == 3) totalScore += 100;
                else if (cnt == 4) totalScore += 1000;
            }
        }

        System.out.println(totalScore);               // 최종 점수 출력
    }

    // 학생 자리 배치 메서드
    static void placeStudent(int student) {
        List<int[]> candidates = new ArrayList<>();   // 후보 좌석 리스트
        int maxLike = -1;                             // 인접 좋아하는 친구 최대 수
        int maxEmpty = -1;                            // 인접 빈칸 최대 수

        // 모든 좌석 탐색
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] != 0) continue;        // 이미 차있으면 패스

                int likeCount = 0;                   // 인접 좋아하는 친구 수
                int emptyCount = 0;                  // 인접 빈칸 수

                // 상하좌우 탐색
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                    if (arr[nx][ny] == 0) emptyCount++;                      // 빈칸이면 카운트
                    else if (liked.get(student).contains(arr[nx][ny])) likeCount++; // 좋아하는 친구 카운트
                }

                // 후보 좌석 판단
                if (likeCount > maxLike || (likeCount == maxLike && emptyCount > maxEmpty)) {
                    candidates.clear();              // 더 좋은 좌석 발견 → 후보 초기화
                    candidates.add(new int[]{i, j});
                    maxLike = likeCount;
                    maxEmpty = emptyCount;
                } else if (likeCount == maxLike && emptyCount == maxEmpty) {
                    candidates.add(new int[]{i, j}); // 동점 후보 추가
                }
            }
        }

        // 후보 중 행/열 가장 작은 좌석 선택
        candidates.sort((a, b) -> (a[0] != b[0]) ? a[0] - b[0] : a[1] - b[1]);
        int[] pos = candidates.get(0);
        arr[pos[0]][pos[1]] = student;                // 자리 배치 완료
    }
}
