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
            int[][] arr = new int[N][2];
             for(int i = 0; i < N; i ++){
                  StringTokenizer st = new StringTokenizer(br.readLine());
                 for(int j = 0 ; j < 2; j ++){
                     int x = Integer.parseInt(st.nextToken());
                     if(x  == 0){
                     	arr[i][0] = 0;
                        arr[i][1] = 0;
                        break;
                     }
                 	arr[i][j] = x ;
                 }
            }
            
            int speed = 0;
            int dis = 0;
            for(int i = 0; i < N; i++){
                    if(arr[i][0] == 1){ // 가속
                        speed += arr[i][1];
                        dis += speed;
                    }else if(arr[i][0] == 2){ // 감속
                       
                        if(speed - arr[i][1] < 0){
                        	speed = 0;
                            continue;
                        }
                        speed -= arr[i][1];
                        dis += speed;
                    }else{
                    	dis += speed;
                    }
                
            }
                System.out.println("#" + test_case + " " + dis);
		}
	}
}