import java.util.*;
import java.io.*;

class Solution {
    static int N;
    static int[][] arr;
    static int[][] dist;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {

            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            dist = new int[N][N];

            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                for (int j = 0; j < N; j++) {
                    arr[i][j] = line.charAt(j) - '0';
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }

            bfs();

            System.out.println("#" + test_case + " " + dist[N-1][N-1]);
        }
    }

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        dist[0][0] = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N)
                    continue;

                int cost = dist[x][y] + arr[nx][ny];

                if (cost < dist[nx][ny]) {
                    dist[nx][ny] = cost;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }
}
