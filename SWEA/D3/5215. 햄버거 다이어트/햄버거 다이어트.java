import java.util.*;
import java.io.*;

class Solution
{

    static int N, L; // N: 재료 개수, L: 칼로리 제한
    static int[] taste, cal;
    static int maxTaste;
    
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
             StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());

            int[] taste = new int[N];
            int[] cal = new int[N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                taste[i] = Integer.parseInt(st.nextToken());
                cal[i] = Integer.parseInt(st.nextToken());
            }

            int[] dp = new int[L+1];

            for(int i = 0; i < N; i++){
                for(int j = L; j >= cal[i]; j --){
                    dp[j] = Math.max(dp[j], dp[j-cal[i]] + taste[i]);
                }
            }
            System.out.println("#" + test_case + " " + dp[L]);
                
		}
	}
}