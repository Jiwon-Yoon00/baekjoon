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
            int P = Integer.parseInt(str[0]);
            int Q = Integer.parseInt(str[1]);
            int R = Integer.parseInt(str[2]);
            int S = Integer.parseInt(str[3]);
            int W = Integer.parseInt(str[4]);
            
            int A = W*P;
            int B = Q;
            if(W > R){
            	B+= (W - R) * S;
            }
            
            int min = Math.min(A,B);

            System.out.println("#" + test_case + " " + min);
		}
	}
}