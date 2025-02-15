import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;


        int tc = Integer.parseInt(br.readLine());

        int i = 1;

        while (tc>0){
            st = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append("Case #").append(i).append(": ").append(a).append(" + ")
                    .append(b).append(" = ").append(a+b).append("\n");
            i++;
            tc--;
        }
        System.out.println(sb);
    }
}