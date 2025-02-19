import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");

        int sum = 0;
        while (st.hasMoreTokens()) { // Corrected iteration
            int x = Integer.parseInt(st.nextToken());
            sum += x * x;
        }

        int verifyNum = sum % 10;
        System.out.println(verifyNum);
    }
}
