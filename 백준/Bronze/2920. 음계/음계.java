import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[8];
        for (int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i < arr.length-1; i++){
            if(arr[i] + 1 == arr[i+1]){
                if(i == arr.length-2){
                    System.out.println("ascending");
                }
            } else if (arr[i] - 1 == arr[i+1]) {
                if(i == arr.length-2){
                    System.out.println("descending");
                }
            }else{
                System.out.println("mixed");
                break;
            }
        }
    }
}