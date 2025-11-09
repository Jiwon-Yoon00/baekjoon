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
            
            int[][] arr = new int[N][N];
            // 입력 받기
            for(int i = 0; i < N; i++){
                String[] map = br.readLine().split(" ");
            	for(int j = 0; j < N; j++){
                    arr[i][j] =  Integer.parseInt(map[j]);
                }
            }
            
            int max = Integer.MIN_VALUE;
             
            for(int i = 0; i <= N - M; i++){
                for(int j = 0; j <= N - M; j++){ 
                	int answer = 0;    
                    for(int k = i; k < i + M; k++){
            			for(int q = j; q < j+ M; q++){
                   			
                            if(k >= N || q >= N) continue;
                            answer += arr[k][q]; 
                		}
           			 }
                    
                    if(answer > max){
                    	max = answer;
                    }
                }
            }
            
            
            System.out.println("#" + test_case + " " + max);
		}
	}
}