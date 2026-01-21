import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int R, C;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        char[][] map = new char[R][C];
        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        if (N == 1) {
            print(map);
            return;
        }

        if (N % 2 == 0) {
            print(fullBomb());
            return;
        }

        char[][] t3 = explode(map);
        
        if((N-3)%4 == 0){
            print(t3);
        }else{
            print(explode(t3));
        }
    }

    static char[][] fullBomb() {
        char[][] res = new char[R][C];
        for (int i = 0; i < R; i++) {
            Arrays.fill(res[i], 'O');
        }
        return res;
    }
    
    static char[][] explode(char[][] map) {
        char[][] res = fullBomb();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'O') {
                    res[i][j] = '.';
                    for (int d = 0; d < 4; d++) {
                        int ni = i + dx[d];
                        int nj = j + dy[d];
                        if (ni >= 0 && nj >= 0 && ni < R && nj < C) {
                            res[ni][nj] = '.';
                        }
                    }
                }
            }
        }
        return res;
    }

    static void print(char[][] map) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < R; i++) {
            sb.append(map[i]).append('\n');
        }
        System.out.print(sb);
    }
}