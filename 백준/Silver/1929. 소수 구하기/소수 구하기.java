import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import static java.lang.Math.sqrt;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        while (M <= N){
            boolean isPrime = true;

            if(M == 1){
                isPrime = false;
            }

            for (int i = 2; i <= Math.sqrt(M); i++) {

                if(M % i == 0){
                    isPrime = false;
                    break;
                }
            }

            if(isPrime){
                sb.append(M).append('\n');
            }
            M++;

        }

        System.out.println(sb);
    }
}


