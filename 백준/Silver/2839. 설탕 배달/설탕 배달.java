import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int[] arr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int cnt = 0;
        while (N > 0){
            if(N % 5 == 0){
                cnt += N/5;
                break;
            }else {
                N -= 3;
                cnt++;
            }
            if(N < 0){
                cnt = -1;
            }
        }

        System.out.println(cnt);
    }
}


