import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st= new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");

        while(st.hasMoreTokens()){
            int x = Integer.parseInt(st.nextToken());

            if(X > x){
                sb.append(x + " ");
            }
        }

        System.out.println(sb);
    }
}