import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int N = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split(" ");
            int[] arr = new int[101];
            for(int i= 0 ; i < str.length; i++){
                arr[Integer.parseInt(str[i])]++;
            }
            
            int max = Integer.MIN_VALUE;
            int answer = 0;
            for(int i= 0 ; i < arr.length; i++){
                if(max <= arr[i] && i > answer) {
                	max = arr[i];
                    answer = i; 
                }
            }
                
            System.out.println("#" + test_case + " " +answer);
		}
	}
}