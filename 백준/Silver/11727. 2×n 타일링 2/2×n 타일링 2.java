import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.stream.Collectors;

public class Main {
    static Long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        dp = new Long[N+1];
        dp[1] = 1L;
        if(N>1) {
            dp[2] = 3L;
        }

        for (int i = 3; i <= N; i++) {
            dp[i] = (dp[i-1] % 10007 + 2*dp[i-2] % 10007) % 10007;
        }

        System.out.println(dp[N]);

    }
}