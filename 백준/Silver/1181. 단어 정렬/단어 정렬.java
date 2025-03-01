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
        int N = Integer.parseInt(br.readLine());
        String arr[] = new String[N];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                if(o1.length() == o2.length()){ // 단어의 길이가 같을 경우
                    return o1.compareTo(o2);
                }
                else { // 그 외의 경우
                    return o1.length() -o2.length();
                }
            }
        });


        StringBuilder sb = new StringBuilder();
        sb.append(arr[0]).append('\n');

        for (int i = 1; i < N; i++) {

            // 중복되지 않는 단어만 출력
            if (!arr[i].equals(arr[i - 1])) {
                sb.append(arr[i]).append('\n');
            }
        }
        System.out.println(sb);

    }
}

