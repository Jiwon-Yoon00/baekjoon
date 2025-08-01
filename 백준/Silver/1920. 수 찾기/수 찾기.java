import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int[] arr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 배열은 반드시 정렬되어있어야한다.
        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), " ");

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < M; i++) {

            // 찾고자 하는 값이 있을 경우 1, 없을 경우 0을 출력해야한다.
            if(binarySerach(Integer.parseInt(st.nextToken())) >= 0) {
                sb.append(1).append('\n');
            }
            else {
                sb.append(0).append('\n');
            }
        }
        System.out.println(sb);

    }

    public static int binarySerach(int key){
        int lo=0;
        int hi = arr.length-1;
        while(lo <= hi){
            int mid = (lo + hi) / 2;

            if(key < arr[mid]){
                hi = mid -1;
            } else if (key > arr[mid]) {
                lo = mid + 1;
            }
            else {
                return mid;
            }
        }
        return -1;
    }
}
