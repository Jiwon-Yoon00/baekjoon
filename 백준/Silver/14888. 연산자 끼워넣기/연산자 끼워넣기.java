import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int N;
    static int[] arr;
    static char[] result;
    static int[] operators;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        result = new char[N -1];
        operators = new int[4];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++){
            operators[i] = Integer.parseInt(st.nextToken());
        }
        
         dfs(1, arr[0]);


        System.out.println(max);
        System.out.println(min);
    }

    static void dfs(int idx, int current){
        if (idx == N) {
            min = Math.min(min, current);
            max = Math.max(max, current);
            return;
        }

       if (operators[0] > 0) {
        operators[0]--;
        dfs(idx + 1, current + arr[idx]);
        operators[0]++;
    }

    if (operators[1] > 0) {
        operators[1]--;
        dfs(idx + 1, current - arr[idx]);
        operators[1]++;
    }

    if (operators[2] > 0) {
        operators[2]--;
        dfs(idx + 1, current * arr[idx]);
        operators[2]++;
    }

    if (operators[3] > 0) {
        operators[3]--;
        dfs(idx + 1, current / arr[idx]);
        operators[3]++;
    }
    }
}