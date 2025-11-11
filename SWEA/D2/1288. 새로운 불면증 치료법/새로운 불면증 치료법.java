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
            int[] num = new int[10];
            int k= 1;
            boolean flag = false;
            
            while(!flag){
                int n = k * N;
            	String str = String.valueOf(n);
                String[] arr = str.split("");
                for(String i : arr){
                	int x = Integer.parseInt(i);
                    num[x]++;
                }
                k++;
                for(int i = 0; i < 10; i ++){
                	if(num[i] == 0){
                        flag = false;
                    	break;
                    }else{
                    	flag = true;
                    }
                }
            
            }
           System.out.println("#" + test_case + " " + (k-1) * N);
		}
	}
}