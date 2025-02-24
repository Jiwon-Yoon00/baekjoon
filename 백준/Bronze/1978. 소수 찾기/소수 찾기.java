import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int count = 0;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[N];

        for(int i=0; i<N; i++){
            boolean isPrime = true;
            arr[i] = Integer.parseInt(st.nextToken());

            if(arr[i] == 1){
                continue;
            }

            for(int k =2; k <= Math.sqrt(arr[i]); k++){
                if(arr[i] % k == 0){
                    isPrime = false;
                    break;
                }
            }

            if(isPrime){
                count++;
            }

        }
        System.out.println(count);

    }
}