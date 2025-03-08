import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        Set<Integer> set = new HashSet<>();
        int x = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            switch (st.nextToken()){
                case "add":
                    x = Integer.parseInt(st.nextToken());
                    set.add(x);
                    break;
                case "check":
                    x = Integer.parseInt(st.nextToken());
                    if(set.contains(x)){
                        sb.append(1).append('\n');
                    }else sb.append(0).append('\n');
                    break;
                case "remove":
                    x = Integer.parseInt(st.nextToken());
                    if(set.contains(x)){
                        set.remove(x);
                    }
                    break;
                case "toggle":
                    x = Integer.parseInt(st.nextToken());
                    if(set.contains(x)){
                        set.remove(x);
                    }else set.add(x);
                    break;
                case "all":
                    for (int j = 0; j < 20; j++) {
                        set.add(j+1);
                    }
                    break;
                case "empty":
                    set.clear();
                    break;
            }
        }

        System.out.println(sb);
    }
}