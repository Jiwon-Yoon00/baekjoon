
import java.io.*;

public class Solution {
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("src/codingTest/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int test_case = 1; test_case <= 10; test_case++) {
            int N = Integer.parseInt(br.readLine()); // 테스트 케이스 번호
            arr = new int[100][100];

            for (int i = 0; i < 100; i++) {
                String[] line = br.readLine().split(" ");
                for (int j = 0; j < 100; j++) {
                    arr[i][j] = Integer.parseInt(line[j]);
                    //if(arr[i][j] == 2) System.out.println("2 위치: " + i + "," + j);
                }
            }

            int startColumn = 0;
            // 0행에서 시작점 찾기
            for (int j = 0; j < 100; j++) {
                if (arr[0][j] == 1) {
                    if (simulate(0, j)) { // 목표 도달하면 출력
                        startColumn = j;
                        break;
                    }
                }
            }
            System.out.println("#" + N + " " + startColumn);
        }
    }

    // 한 경로 시뮬레이션
    public static boolean simulate(int x, int y) {
        while (x < 100) {
            // 왼쪽으로 이동 가능한 동안 이동
        	 if (y > 0 && arr[x][y-1] == 1) {
                 while (y > 0 && arr[x][y-1] == 1) y--;
             }
             // 왼쪽 이동 없으면 오른쪽 이동
             else if (y < 99 && arr[x][y+1] == 1) {
                 while (y < 99 && arr[x][y+1] == 1) y++;
             }

             // 목표 2 체크
             if (arr[x][y] == 2) return true;
            x++;
        }
        return false;
    }
}

