import java.util.*;
import java.io.*;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N];

            int num = 1;
            int x = 0, y = 0;
            int dir = 0; // 0: 우, 1: 하, 2: 좌, 3: 상
            int[] dx = {0, 1, 0, -1};
            int[] dy = {1, 0, -1, 0};

            while(num <= N * N) {
                arr[x][y] = num++;
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N || arr[nx][ny] != 0) {
                    dir = (dir + 1) % 4; // 방향 전환
                    nx = x + dx[dir];
                    ny = y + dy[dir];
                }

                x = nx;
                y = ny;
            }

            System.out.println("#" + test_case);
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
