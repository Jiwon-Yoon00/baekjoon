import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        if(n >= 90){
            sb.append("A");
        } else if (n >= 80) {
            sb.append("B");
        } else if (n >= 70) {
            sb.append("C");
        }else if (n >= 60) {
            sb.append("D");
        } else {
            sb.append("F");
        }
        System.out.println(sb);
    }
}
