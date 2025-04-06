import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static String maze[][];
    static boolean visited[][];
    static int N;
    static int M;
    static int cx;
    static int cy;
    static int dx[] = {0, -1, 0, 1};
    static int dy[]={1, 0, -1, 0};
    static int cnt;

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maze = new String[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                if(str.charAt(j) == 'I'){
                    cx = i;
                    cy= j;
                }
                maze[i][j] = String.valueOf(str.charAt(j));
            }
        }

        dfs(cx, cy);

        if(cnt != 0){
            System.out.println(cnt);
        }else {
            System.out.println("TT");
        }
    }

    static void dfs(int x, int y){
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int cx = x + dx[i]; // 상하좌우를 검사해야 하므로
            int cy = y + dy[i];


                if(cx >= 0 && cy >=0 && cx < N && cy < M ){
                    if(!visited[cx][cy] && !maze[cx][cy].equals("X")) {
                        if(maze[cx][cy].equals("P")){
                            cnt++;
                        }
                        dfs(cx,cy);
                    }
                }

        }
    }
}