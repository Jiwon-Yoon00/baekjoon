import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.BigInteger;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args)  throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);

        BigInteger[][] dp = new BigInteger[N+1][M+1];
        
      
        for(int i = 1; i <= N; i++){
            for(int j = 0; j <= Math.min(i, M); j++){
               if (j == 0 || j == i) {
                    dp[i][j] = BigInteger.ONE;
                } else {
                    dp[i][j] = dp[i - 1][j - 1].add(dp[i - 1][j]);
                }
               
            }
        }
        System.out.println(dp[N][M]);
    }
}