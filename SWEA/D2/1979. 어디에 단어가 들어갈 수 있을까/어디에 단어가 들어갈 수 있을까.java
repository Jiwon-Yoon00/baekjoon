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
            int K = Integer.parseInt(str[1]);
            int[][] arr = new int[N][N];
            
            for(int i =0; i < N; i++){
            	StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j =0 ; j< N; j++){
                	arr[i][j] = Integer.parseInt(st.nextToken()); 
                }
            }
            
           
            int cnt = 0;
            
            for(int i =0; i< N; i++){
                 int length = 0;
                for(int j =0 ; j< N; j++){
                	if(arr[i][j] == 1){
                        length++;      
                    }else{
                       
                    	if(length == K) {
                        	cnt ++;
                        }
                         length = 0;
                    }
                    
                    if(length > K) { 
                    	length = 0;
                    }
                }
                
                if(length == K) {
                	cnt++;
                }
            }
            
            for(int i =0; i< N; i++){
                 int length = 0;
                for(int j =0 ; j< N; j++){
                	if(arr[j][i] == 1){ 
                        length++;      
                    }else{
                       
                    	if(length == K) {
                        	cnt ++;
                        }
                         length = 0;
                    }
                    

                   if(length > K) {
                    	length = 0;
                    }
                }
                 if(length == K) {
                	cnt++;
                }
            }
            
            System.out.println("#" + test_case + " " + cnt);
		}
	}
    

}