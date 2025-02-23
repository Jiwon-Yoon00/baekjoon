import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for(int i = 0; i< tc; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());


            String floor = "";

            if(N % H == 0){
                floor = Integer.toString(H);
            } else {
                floor = Integer.toString(N % H);
            }

            int room = N / H + 1;

            if(N%H == 0){
                room --;
            }

            String str = Integer.toString(room);

            if(str.length() != 2){
                str = "0" + str;
            }
            System.out.println(floor + str);

        }
    }
}