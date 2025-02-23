import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        int num = 0;
        int total = 0;
        for(int i = 0; i < tc; i++){
            String str = br.readLine();

            for (int j=0; j<str.length(); j++){
                if(str.charAt(j) == 'O') {
                    num++;
                    if(num != 1){
                        total += num;
                        continue;
                   }
                    total += num;
               }else {
                    num = 0;
                }
            }
            System.out.println(total);
            total = 0;
            num = 0;
        }
    }
}