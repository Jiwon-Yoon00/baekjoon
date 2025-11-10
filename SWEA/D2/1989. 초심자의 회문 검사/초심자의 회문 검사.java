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
            String str = br.readLine();
            int answer = 1;
            int left = 0;
            int right = str.length()-1; 
            
            while(left <= right){
                String[] arr = str.split("");
                
                if(arr[left].equals(arr[right])){
                	left++;
                    right--;
                }else{
                	answer = 0;
                    break;
                }
            }
            System.out.println("#" + test_case + " " + answer);
		}
	}
}