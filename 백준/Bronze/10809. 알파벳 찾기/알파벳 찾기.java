import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] arr = new int[26];
        for(int i =0; i <arr.length; i++){
            arr[i] = -1;
        }

        String str = br.readLine();
        for(int i = 0; i <str.length(); i++){
            if(arr[str.charAt(i) - 97 ] == -1){
                arr[str.charAt(i) - 97] = i;
            }
        }

        for(int value: arr){
            sb.append(value).append(" ");
        }
        System.out.println(sb);
    }
}