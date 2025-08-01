import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        StringTokenizer st= new StringTokenizer(str, " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        sb.append(a+b);
        sb.append('\n');

        sb.append(a-b);
        sb.append('\n');

        sb.append(a*b);
        sb.append('\n');

        sb.append(a/b);
        sb.append('\n');

        sb.append(a%b);


        System.out.println(sb);

    }
}
