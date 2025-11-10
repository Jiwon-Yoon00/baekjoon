import java.util.*;
import java.io.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
            StringBuilder sb = new StringBuilder();
            int N = Integer.parseInt(br.readLine());
             int cnt = 0;
            for(int i  = 0; i < N; i++){
                String[] str = br.readLine().split(" ");
                String alpabet = str[0];
                int num = Integer.parseInt(str[1]);
               
                for(int j = 0; j < num; j ++){
                    sb.append(alpabet);
                    cnt ++;
                    if(cnt == 10) {
                    	sb.append("\n");
                        cnt = 0;
                    }
                }
            }
            System.out.println("#" + test_case);
            System.out.println(sb);
		}
	}
}