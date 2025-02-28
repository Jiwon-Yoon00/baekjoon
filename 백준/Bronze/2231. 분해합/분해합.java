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
        String str = br.readLine();
        int N = Integer.parseInt(str);
        int N_length  = str.length();
        int result = 0;

        for(int i =N - 9*N_length; i<N ; i++){
            int sum = 0;
            int number = i;

            while(number !=0 ){
                sum += number % 10;
                number /= 10;
            }

            if(sum + i == N){
                result = i;
                break;
            }
        }
        System.out.println(result);
    }

}