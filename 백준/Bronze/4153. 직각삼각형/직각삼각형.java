import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            if(x == 0 && y == 0 && z ==0){
                break;
            }

            if((x*x) + (y*y) == (z*z) || (z*z) + (y*y) == (x*x) || (x*x) + (z*z) == (y*y)){
                System.out.println("right");
            }else System.out.println("wrong");
        }
    }
}