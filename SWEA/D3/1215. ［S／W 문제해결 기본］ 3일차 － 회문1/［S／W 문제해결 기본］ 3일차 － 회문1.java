import java.util.*;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		/*
		아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
		여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
		이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		*/
		//System.setIn(new FileInputStream("src/codingTest/input.txt"));
		
		Scanner sc = new Scanner(System.in);
		
		/*
		여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/
		
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			String[][] map = new String[8][8];
			int N = sc.nextInt();
			sc.nextLine();
			
			int answer = 0;
			
			// 입력받기
			for(int i = 0; i < 8; i++) {
				String[] line = sc.nextLine().split("");
				for(int j =0; j < 8; j++) {
					map[i][j] = line[j];
				}
			}
			
			// 가로
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < 8; i ++) {
				for(int j = 0; j < 8; j++) {
					String str = "";
					if(j <= 8 - N) {
						for(int k = j; k < j+N; k ++) {
							str += map[i][k];
						}
						String reverse = new StringBuilder(str).reverse().toString();
						if(reverse.equals(str)) answer++;
					}
				}
			}
			
			// 세로
			for(int i = 0; i < 8; i ++) {
				for(int j = 0; j < 8; j++) {
					String str = "";
					if(j <= 8 - N) {
						for(int k = j; k < j+N; k ++) {
							str += map[k][i];
						}
						String reverse = new StringBuilder(str).reverse().toString();
						if(reverse.equals(str)) answer++;
					}
				}
			}
			
			System.out.println("#" + test_case + " " + answer);
			
		}
	}
}