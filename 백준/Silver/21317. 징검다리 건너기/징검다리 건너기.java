import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] cost = new int[N + 1][2];
        for (int i = 1; i <= N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cost[i][0] = Integer.parseInt(st.nextToken()); // 1칸
            cost[i][1] = Integer.parseInt(st.nextToken()); // 2칸
        }

        int K = Integer.parseInt(br.readLine());

        final int INF = 1_000_000_000;
        int[][] dp = new int[N + 1][2];

        for (int i = 1; i <= N; i++) {
            dp[i][0] = dp[i][1] = INF;
        }

        dp[1][0] = 0; // 시작점

        for (int i = 2; i <= N; i++) {
            // 1칸
            dp[i][0] = Math.min(dp[i][0], dp[i - 1][0] + cost[i - 1][0]);
            dp[i][1] = Math.min(dp[i][1], dp[i - 1][1] + cost[i - 1][0]);

            // 2칸
            if (i >= 3) {
                dp[i][0] = Math.min(dp[i][0], dp[i - 2][0] + cost[i - 2][1]);
                dp[i][1] = Math.min(dp[i][1], dp[i - 2][1] + cost[i - 2][1]);
            }

            // 큰 점프 (딱 한 번)
            if (i >= 4) {
                dp[i][1] = Math.min(dp[i][1], dp[i - 3][0] + K);
            }
        }

        System.out.println(Math.min(dp[N][0], dp[N][1]));
    }
}
