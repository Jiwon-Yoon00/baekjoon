import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static int N;
    static int[][] colorPaper;
    static int blue = 0;
    static int white = 0;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        colorPaper = new int[N][N];

        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < N; j++) {
                colorPaper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        partition(0,0, N);
        System.out.println(white);
        System.out.println(blue);

    }
    public static void partition(int row, int col, int size){
        if(colorCheck(row, col, size)){
            if(colorPaper[row][col] == 0){
                white++;
            }else {
                blue++;
            }
            return;
        }
        int newSize = size/2;

        partition(row, col, newSize);
        partition(row, col + newSize, newSize);
        partition(row + newSize, col, newSize);
        partition(row + newSize, col+newSize, newSize);
    }
    public static boolean colorCheck(int row, int col, int size){
        int color = colorPaper[row][col]; // color 는 1 아니면 0;

        for (int i = row; i < row + size ; i++) {
            for (int j = col; j < col + size ; j++) {
                if(colorPaper[i][j] != color){ // 옆쪽으로 가면서 색상이 같지 않다면 false
                    return false;
                }
            }
        }
        return true;
    }
}