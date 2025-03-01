import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Math.sqrt;
import static java.util.Collections.sort;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());
        int[] cnt = new int[10001];

        for(int i =0; i < tc; i++){
            cnt[Integer.parseInt(br.readLine())] ++; // 과정 1
        }

        br.close();

        for (int i = 1; i <  10001; i++) {
            while (cnt[i] > 0){ // cnt[i] 에 값이 있을 경우에만
                sb.append(i); 
                sb.append("\n");
                cnt[i]--;
            }
        }

        System.out.println(sb);
    }
}


