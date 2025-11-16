
import java.util.*;
import java.io.*;

public class Solution {
	static int N;
	static boolean[] colUsed;
	static boolean[] diag1Used;
	static boolean[] diag2Used;
	static int answer;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = Integer.parseInt(br.readLine());
			colUsed = new boolean[N];
			diag1Used = new boolean[2 * N];
            diag2Used = new boolean[2 * N];
            answer = 0;
            
            backtrack(0);

            System.out.println("#" + test_case + " " + answer);
		}
	}
	
	static void backtrack(int row){
		if(row == N) {
			answer++;
			return;
		}
		for(int col = 0; col < N; col ++) {
			if(colUsed[col]) continue;
			if (diag1Used[row + col]) continue;
	        if (diag2Used[row - col + N - 1]) continue;
	        
	        colUsed[col] = true;
	        diag1Used[row+col] = true;
	        diag2Used[row - col + N - 1] = true;
	        
	        backtrack(row+1);
	        
	        colUsed[col] = false;
            diag1Used[row + col] = false;
            diag2Used[row - col + N - 1] = false;
		}
	}
}
