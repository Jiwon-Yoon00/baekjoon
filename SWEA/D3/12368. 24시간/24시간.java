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
            String[] str = br.readLine().split(" ");
            int A = Integer.parseInt(str[0]);
            int B = Integer.parseInt(str[1]); 
            
            int answer = 0;
            int sum = A + B;
            if(sum == 24){
            	answer = 0;
            }else if(sum > 24){
            	answer = sum - 24;
            }else{
            	answer = sum;
            }
            
            System.out.println("#" + test_case + " " + answer);
		}
	}
}