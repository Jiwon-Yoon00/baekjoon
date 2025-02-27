import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Math.sqrt;
import static java.util.Collections.sort;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int d = gcd(n,m); // 최대공약수


        System.out.println(d);
        System.out.println(n*m / d);
    }
    public static int gcd(int a, int b){
        if(b == 0) {
            return  a;
        }
        return gcd(b, a%b);
    }
}
