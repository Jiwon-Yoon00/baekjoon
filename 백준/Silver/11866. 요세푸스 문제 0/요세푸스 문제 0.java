import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        sb.append('<');
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            q.add(i);
        }

        while (!q.isEmpty()){
            for (int i = 0; i < K-1; i++) {
                int val = q.poll();
                q.offer(val);
            }
            if(q.size() == 1){
                sb.append(q.poll());
                break;
            }
            sb.append(q.poll()).append(",").append(" ");
        }
        sb.append('>');

        System.out.println(sb);
    }
}


