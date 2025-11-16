import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            int[][] map = new int[N][N];

            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = line.charAt(j) - '0';
                }
            }

            int sum = 0;
            int mid = N / 2;

            for (int i = 0; i < N; i++) {
              
                int left = Math.abs(mid - i);   
                int right = N - 1 - left;      // 오른쪽 끝

                for (int j = left; j <= right; j++) {
                    sum += map[i][j];
                }
            }

            System.out.println("#" + test_case + " " + sum);
        }
    }
}
