import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        int arr[] = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 정렬을 한 번만 수행
        Arrays.sort(arr);

        sb.append(mean(arr)).append('\n');
        sb.append(mid(arr)).append('\n');
        sb.append(mode(arr)).append('\n');
        sb.append(range(arr)).append('\n');

        System.out.println(sb);
    }

    public static int mean(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return (int)Math.round((double)sum / arr.length);
    }

    public static int mid(int[] arr) {
        return arr[arr.length / 2]; // 이미 정렬된 배열 사용
    }

    public static int mode(int[] arr) {
        int[] counting = new int[8001]; // -4000 ~ 4000 범위를 저장할 배열
        int maxFreq = 0; // 최빈값의 최대 빈도수
        List<Integer> modes = new ArrayList<>();

        for (int num : arr) {
            counting[num + 4000]++;
            maxFreq = Math.max(maxFreq, counting[num + 4000]); // 최빈값의 빈도를 찾음
        }

        // 최빈값 후보 찾기
        for (int i = 0; i < counting.length; i++) {
            if (counting[i] == maxFreq) {
                modes.add(i - 4000); // 원래 숫자로 변환하여 저장
            }
        }

        // 두 번째로 작은 최빈값 반환 (최빈값이 하나라면 첫 번째 값 반환)
        return modes.size() > 1 ? modes.get(1) : modes.get(0);
    }

    public static int range(int[] arr) {
        return arr[arr.length - 1] - arr[0]; // 정렬된 배열 사용
    }
}
