import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tCnt = 0;
        int y =0;
        int z = 0;

        int N = Integer.parseInt(br.readLine()); // 참가자의 수

        int[] arr = new int[6];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i =0; i< arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");

        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        for(int i=0; i< arr.length; i++){
            tCnt += arr[i]/T;

            if(arr[i] % T > 0){
                tCnt++;
            }
        }
        System.out.println(tCnt);

        y = N / P;
        z = N % P;

        System.out.println(y +" "+z);

    }
}