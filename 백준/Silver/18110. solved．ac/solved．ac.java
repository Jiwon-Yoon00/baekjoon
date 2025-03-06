import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];

        for(int i =0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        float sum = 0;
        int rate = (int) Math.round(arr.length*0.15);
        for (int i = rate; i < n-rate ; i++) {
            sum += arr[i];
        }

        System.out.println(Math.round(sum/(arr.length - rate*2)));
    }
}
