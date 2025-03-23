import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            int N = Integer.parseInt(br.readLine());
            dp = new long[101];

            for (int j = 1; j <= 3; j++) {
                dp[j] = 1;
            }

            for (int j = 4; j <= 5 ; j++) {
                dp[j] = 2;
            }

            for (int j = 6; j < N+1; j++) {
                dp[j] = dp[j-1] + dp[j-5];
            }
            System.out.println(dp[N]);
        }

    }

}