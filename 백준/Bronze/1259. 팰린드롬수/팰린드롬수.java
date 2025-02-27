import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.util.Collections.sort;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String str = st.nextToken();

            if(Integer.parseInt(str) == 0){
                break;
            }
            boolean isCheck = true;
            for(int i=0; i< str.length()/2; i++){
                if(str.charAt(i) != str.charAt(str.length() - i -1)){
                    isCheck = false;
                    System.out.println("no");
                    break;
                }
            }

            if(isCheck){
                System.out.println("yes");
            }
        }
    }
}
