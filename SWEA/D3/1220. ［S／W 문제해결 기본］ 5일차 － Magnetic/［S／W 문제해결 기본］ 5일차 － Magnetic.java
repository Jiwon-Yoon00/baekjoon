

import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        // 로컬 테스트용 (제출 시에는 주석 처리하거나 삭제)
        //System.setIn(new FileInputStream("src/codingTest/input.txt"));
        
        Scanner sc = new Scanner(System.in);
        int T = 10;

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            sc.nextLine(); // 버퍼 비우기 (아주 잘하셨습니다!)
            
            int[][] arr = new int[N][N];
            
            // 1. 입력 받기
            for(int i = 0; i < N; i ++) {
                StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
                for(int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            int answer = 0;

            // 2. 열(Column) 우선 탐색 (세로로 훑기)
            // j: 열 (가로 좌표), i: 행 (세로 좌표)
            for(int j = 0; j < N; j++) {
                
                // isNFound: 위에서 떨어지는 N극(1)이 있었는지 확인하는 플래그
                boolean isNFound = false; 
                
                for(int i = 0; i < N; i++) {
                    int num = arr[i][j]; // 위에서 아래로 내려가며 확인
                    
                    if(num == 1) {
                        // N극 발견! 이제 밑으로 떨어집니다.
                        // S극을 만날 때까지 기억합니다.
                        isNFound = true;
                    }
                    else if(num == 2) {
                        // S극 발견!
                        // 만약 위에서 떨어지던 N극이 있었다면? -> 교착 상태 발생!
                        if(isNFound) {
                            answer++;
                            isNFound = false; // 교착 상태 하나를 셌으므로 초기화 (1-1-2 같은 경우 방지)
                        }
                    }
                }
            }
            
            System.out.println("#" + test_case + " " + answer);
        }
    }
}