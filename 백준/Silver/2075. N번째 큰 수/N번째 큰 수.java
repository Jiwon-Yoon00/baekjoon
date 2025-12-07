import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N*N];
        for(int i = 0; i < N ;i ++){
            String[] line = br.readLine().split(" ");
            for(int j = 0; j < N; j++){
                arr[j + N*i] = Integer.parseInt(line[j]); 
            }
        }

        Arrays.sort(arr);

        System.out.println(arr[arr.length-N]);
    }
}