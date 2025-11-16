
import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[100];
			String[] str = br.readLine().split(" ");
			
			// 입력받기
			for(int i = 0; i < 100; i++) {
				arr[i] = Integer.parseInt(str[i]);
			}
			
			// 정렬하고 제일 큰 값 - 1, 제일 작은 값 + 1; 하고 다시 반복문 돌려서 정렬..
			for(int i= 0; i < N; i++) {
				Arrays.sort(arr);
				int min = arr[0];
				int max = arr[99];
				min += 1;
				max -= 1;
				arr[0] = min;
				arr[99] = max;
			}
			
			Arrays.sort(arr);
			System.out.println("#" + test_case + " " + (arr[99] - arr[0]));

		}
	}
}
