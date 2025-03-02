import java.beans.PropertyEditorSupport;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import static java.util.Collections.sort;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int arr[][] = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] =Integer.parseInt(st.nextToken());
        }

        int result[] = new int[N];

        for (int i = 0; i < N; i++) {
            result[i] = 1;
        }

        // 덩치 비교
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N ; j++) {
                if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]){
                    result[i] += 1;
                } else if (arr[i][0] > arr[j][0] && arr[i][1] > arr[j][1]) {
                    result[j] += 1;
                }
            }
        }

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] +" ");
        }
    }
}
