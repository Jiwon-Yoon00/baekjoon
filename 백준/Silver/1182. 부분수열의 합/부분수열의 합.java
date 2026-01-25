import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int N;
    static int S;
    static int[] arr;
    static int cnt;
   
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        if (S == 0) cnt--;
        dfs(0, 0);
        
        System.out.println(cnt);
    }

    static void dfs(int idx, int sum){

        if(idx == N){
            if(S == sum) cnt++;
            return;
        }

        dfs(idx + 1, sum);

        dfs(idx + 1, sum + arr[idx]);
    }
}