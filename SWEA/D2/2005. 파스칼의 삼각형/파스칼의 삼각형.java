import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            int[] newArr = new int[N];
            arr[0] = 1;
            newArr[0] = 1;
            System.out.println("#" + test_case);
            
            for(int i = 0; i < N; i++){
            	for(int j = 0; j < i+1 ; j ++){
                    if(j == 0) {
                    	arr[j] = 1;
                    }else{
                        newArr[j] = arr[j-1] + arr [j];
                        
                    }
                    System.out.print(newArr[j] + " ");
                }
                arr = Arrays.copyOf(newArr, newArr.length);
                 System.out.println();
            }
		}
	}
}