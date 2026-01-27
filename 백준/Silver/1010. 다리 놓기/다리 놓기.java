import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); 
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            //System.out.println(N + ", " + M);
            int[][] dp = new int[N + 1][M+ 1];

            for(int j = 0; j <= M; j++){
                dp[0][j] = 1;
            }

            for(int i = 1; i <= N; i++){
                for(int j = i; j <= M; j++){
                    if(i == j){
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
                    }
                }
            }
            sb.append(dp[N][M]).append("\n");
        }
        System.out.println(sb);
    }
}