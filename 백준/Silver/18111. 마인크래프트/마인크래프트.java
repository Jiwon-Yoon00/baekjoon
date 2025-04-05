import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];

        int min = 256;
        int max = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(min > arr[i][j]) min = arr[i][j];
                if(max < arr[i][j]) max = arr[i][j];
            }
        }

        int time = Integer.MAX_VALUE;
        int high = 0;
        for (int i = min; i <= max; i++) {
            int second = 0;
            int block = B;
            for (int j = 0; j <N ; j++) {
                for (int k = 0; k < M; k++) {

                    if(arr[j][k] > i){ // 층수가 더 높다면
                        second += (arr[j][k] - i) * 2;
                        block += (arr[j][k] - i);
                    }else if(arr[j][k] < i){
                        second += (i - arr[j][k]);
                        block -= (i - arr[j][k]);
                    }
                }
            }
            if(block < 0) continue;
            if(time >= second){
                time = second;
                high = Math.max(high, i);
            }
        }

        System.out.println(time + " " + high);
    }
}