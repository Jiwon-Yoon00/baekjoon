import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        while (tc > 0){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int R = Integer.parseInt(st.nextToken());
            String str = st.nextToken();

            for(int i = 0; i < str.length(); i++){
                for(int j = 0; j < R; j++){
                    System.out.print(str.charAt(i));
                }
            }
            System.out.println();
            tc--;
        }

    }
}
