import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine().trim());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] prices = new int[N];
            for (int i = 0; i < N; i++) {
                prices[i] = Integer.parseInt(st.nextToken());
            }

            long profit = 0L;
            int maxFuture = 0;
            for (int i = N - 1; i >= 0; i--) {
                if (prices[i] < maxFuture) {
                    profit += (long)(maxFuture - prices[i]);
                } else {
                    maxFuture = prices[i];
                }
            }

            System.out.println("#" + tc + " " + profit);
        }
    }
}
