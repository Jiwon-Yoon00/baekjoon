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
            int N = Integer.parseInt(str[0]);
            int M = Integer.parseInt(str[1]);
            
            int[] a = new int[N];
            int[] b= new int[M];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
            	a[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
 			 for(int i = 0; i < M; i++){
            	b[i] = Integer.parseInt(st.nextToken());
            }
            
            
            int result = Integer.MIN_VALUE;
            int max = Math.max(a.length, b.length);
            int min = Math.min(a.length, b.length);
			int len = max- min;
            
            for(int i = 0; i < len + 1; i ++){
                int sum = 0;
            	for(int j = 0 ; j < min; j++){
                    if(min == a.length){
                    	sum += a[j] * b[i + j];
                    }else{
                    	sum += b[j] * a[i + j];
                    }
                }
                if(sum > result) result = sum;
			}
            System.out.println("#" + test_case + " " + result);  
        }
	}
}