import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String x = br.readLine();
        StringTokenizer st = new StringTokenizer(x, "-");
        int sum = Integer.MAX_VALUE;
        while (st.hasMoreTokens()){
            int temp = 0;
            StringTokenizer add = new StringTokenizer(st.nextToken(),"+");

            while (add.hasMoreTokens()){
                temp +=Integer.parseInt( add.nextToken());
            }

            if(sum == Integer.MAX_VALUE){
                sum = temp;
            }else {
                sum -= temp;
            }
        }

        System.out.println(sum);
    }
}