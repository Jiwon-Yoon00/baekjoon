import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] month = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
        for(int test_case = 1; test_case <= T; test_case++)
		{
            int answer = 0;
           	String[] str = br.readLine().split(" ");
			int firstMonth = Integer.parseInt(str[0]);
            int firstDay = Integer.parseInt(str[1]);
            int secondMonth = Integer.parseInt(str[2]);
            int secondDay = Integer.parseInt(str[3]);

            if(firstMonth == secondMonth){
            	answer += secondDay - firstDay;
            }else{
            	answer += (month[firstMonth] - firstDay)  + secondDay;
                firstMonth++;
            }
           
            while(firstMonth != secondMonth){  
                answer += month[firstMonth]; 
                firstMonth++;
            }
                
           System.out.println("#" + test_case + " " + (answer + 1));
		}
	}
}