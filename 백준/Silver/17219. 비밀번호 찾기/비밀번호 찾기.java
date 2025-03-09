import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String site = st.nextToken();
            String password = st.nextToken();
            map.put(site, password);
        }

        for (int i = 0; i < M; i++) {
            String searchPassword = br.readLine();
            if(map.containsKey(searchPassword)){
                sb.append(map.get(searchPassword)).append('\n');
            }
        }

        System.out.println(sb);
    }
}