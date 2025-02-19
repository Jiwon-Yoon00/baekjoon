import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        if((n % 4 == 0) && (n % 100 != 0)){
            sb.append(1);
        } else if (n % 400 == 0) {
            sb.append(1);
        } else {
            sb.append(0);
        }
        System.out.println(sb);
    }
}
