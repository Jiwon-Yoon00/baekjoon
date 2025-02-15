import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        String b = br.readLine();

        br.close();

        StringBuilder sb = new StringBuilder();

        sb.append(a*(b.charAt(2) - '0'));
        sb.append('\n');

        sb.append(a*(b.charAt(1) - '0'));
        sb.append('\n');

        sb.append(a*(b.charAt(0) - '0'));
        sb.append('\n');

        sb.append(a * Integer.parseInt(b) );
        sb.append('\n');

        System.out.print(sb);
    }
}
