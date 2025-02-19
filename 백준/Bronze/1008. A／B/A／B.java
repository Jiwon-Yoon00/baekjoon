import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        double a = Integer.parseInt(st.nextToken());
        double b = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        sb.append(a / b);
        System.out.println(sb);
    }
}
