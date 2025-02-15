import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        while(true){
            String str =  br.readLine();
            StringTokenizer st = new StringTokenizer(str, " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(a == 0 && b == 0){
                 break;
            }

            StringBuilder sb = new StringBuilder();
            sb.append(a+b);
            sb.append("\n");

            System.out.print(sb);
        }
        br.close();
    }
}
