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
        int n =Integer.parseInt(br.readLine());
        String str = br.readLine();
        int a = 0;
        int sum = 0;
        for(int i =0;i<n; i++){
            a = str.charAt(i) - 'a' + 1;
            sum += (a * power(31, i)) % 1234567891;
        }
        System.out.println(sum);
    }

    public static long power(int base, int exp){
        long result = 1;
        for(int i=0; i< exp; i++){
            result *= base;
        }

        return  result;
    }

}
