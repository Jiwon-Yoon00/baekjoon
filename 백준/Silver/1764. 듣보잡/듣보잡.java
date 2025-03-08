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

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            map.put(br.readLine(), 1);
        }

        List<String> tempSet = new ArrayList<>();


        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            map.put(name, map.getOrDefault(name,0) +  1);
            if (map.get(name) == 2) tempSet.add(name);
        }


        Collections.sort(tempSet);

        sb.append(tempSet.size() + "\n");

        for (String value: tempSet){
            sb.append(value + "\n");
        }

        System.out.println(sb);

    }
}