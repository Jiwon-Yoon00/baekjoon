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
        int n =Integer.parseInt(br.readLine());
        String str = br.readLine();
        int a = 0;
        long r =1;
        long sum = 0;

        int mod = 1234567891;

        for(int i =0;i<n; i++){
            a = str.charAt(i) - 'a' + 1;
            sum += (a * r) % mod;
            r = (r*31) % mod;
        }
        System.out.println(sum%mod);
    }
    
}

