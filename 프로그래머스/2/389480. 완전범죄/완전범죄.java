import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        // dp[a][b] = a만큼의 A 흔적, b만큼의 B 흔적이 가능한지 여부 (단, a < n, b < m)
        boolean[][] dp = new boolean[n][m];
        dp[0][0] = true;

        for (int[] item : info) {
            int aCost = item[0];
            int bCost = item[1];

            boolean[][] next = new boolean[n][m];

            for (int a = 0; a < n; a++) {
                for (int b = 0; b < m; b++) {
                    if (!dp[a][b]) continue;

                    // 1) A가 훔치는 경우
                    int na = a + aCost;
                    int nb = b;
                    if (na < n) next[na][nb] = true; // 잡히지 않으면 허용

                    // 2) B가 훔치는 경우
                    na = a;
                    nb = b + bCost;
                    if (nb < m) next[na][nb] = true; // 잡히지 않으면 허용
                }
            }

            dp = next;
        }

        // 가능한 상태들 중 A의 누적이 최소인 값 찾기
        for (int a = 0; a < n; a++) {
            for (int b = 0; b < m; b++) {
                if (dp[a][b]) return a;
            }
        }

        return -1; // 어떤 배치로도 두 도둑이 모두 잡히지 않게 할 수 없음
    }
}
