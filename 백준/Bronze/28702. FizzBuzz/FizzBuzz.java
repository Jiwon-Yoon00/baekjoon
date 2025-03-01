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

        String str1 = br.readLine();
        String str2 = br.readLine();
        String str3 = br.readLine();

        int num = 0;

        if (!str1.equals("Fizz") && !str1.equals("Buzz") && !str1.equals("FizzBuzz")){
            num = Integer.parseInt(str1);
            num += 3;
            print(num);
        } else if (!str2.equals("Fizz") && !str2.equals("Buzz") && !str2.equals("FizzBuzz")){
            num = Integer.parseInt(str2);
            num += 2;
            print(num);
        } else if (!str3.equals("Fizz") && !str3.equals("Buzz") && !str3.equals("FizzBuzz")){
            num = Integer.parseInt(str3);
            num += 1;
            print(num);
        }

    }

    public static void print(int num){

        if(num % 3 == 0){
            if(num % 5 ==0){
                System.out.println("FizzBuzz");
            }else if(num % 5 != 0) System.out.println("Fizz");
        }
        else if (num % 3 != 0) {
            if(num % 5 ==0){
                System.out.println("Buzz");
            }else if(num % 5 != 0) System.out.println(num);
        }

    }
}

