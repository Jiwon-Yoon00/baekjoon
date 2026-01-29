import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
    
        int[] arr = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N + 1];
        for(int i = 1; i <= N; i++){
            dp[i] = arr[i];
            for(int j = 1; j < i; j++){
                if(arr[j] < arr[i]){
                    dp[i] = Math.max(dp[i], dp[j] + arr[i]); 
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            answer = Math.max(answer, dp[i]);
            //System.out.println(dp[i]);
        }
    
        System.out.println(answer);

    }
}