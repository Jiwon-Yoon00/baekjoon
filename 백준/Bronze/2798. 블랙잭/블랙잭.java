import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.util.Collections.sort;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int arr[] = new int[N];

        st = new StringTokenizer(br.readLine(), " ");

        for(int i=0; i< N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = search(arr, N, M);
        System.out.println(result);

    }

    static int search(int[] arr, int N, int M) {

        int result = 0;

        for (int i = 0; i < N - 2; i++) {

            // 첫 번째 카드가 M 보다 크면 skip
            if(arr[i] > M) continue;

            for (int j = i+1; j < N - 1; j++) {

                // 두 번째 카드와 첫 번째 카드의 합이 M보다 크면 skip
                if(arr[i] + arr[j] > M) continue;

                for (int k = j+1; k < N; k++) {

                    int temp = arr[i] + arr[j] + arr[k];

                    if (M == temp) {
                        return temp;
                    }

                    if (result < temp && temp < M) {
                        result = temp;
                    }

                }
            }
        }
        return result;
    }
}
