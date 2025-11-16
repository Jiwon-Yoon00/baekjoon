import java.util.*;
import java.io.*;

public class Solution {
	static int N;
	static int[] score;
	static boolean[] result;
	static int total;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = Integer.parseInt(br.readLine());
			String[] line = br.readLine().split(" ");
			score = new int[N];
			result = new boolean[N];
			total = 0;
			for(int i = 0; i < N; i ++) {
				score[i] = Integer.parseInt(line[i]);
				total += score[i];
			}
			
			 boolean[] possible = new boolean[total + 1];
			 possible[0] = true; // 아무것도 안 더한 합

			    for (int x : score) {
			       for (int s = total; s >= x; s--) {
			           if (possible[s - x]) {
			               possible[s] = true;
			           }
			       }
			    }

			   int cnt = 0;
			   for (boolean b : possible) {
			       if (b) cnt++;
			   }

			   System.out.println("#" + test_case + " " + cnt);
		}
	}
	
	
}