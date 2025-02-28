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
        int tc =Integer.parseInt(br.readLine());

        for(int i = 0; i < tc; i++){
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            int x = resident(k,n);
            System.out.println(x);

        }
    }

    public static int resident(int k, int n){
        int x = 0;

        if(k == 0){ // 0층일 때 사람 수는 n명
            x = n;
            return x;
        }

        for(int i = 1; i <= n; i++){
            x += resident(k-1, i);
        }
        return x;
    }

}
