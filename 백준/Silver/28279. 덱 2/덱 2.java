import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        Deque<Integer> deque = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            switch (Integer.parseInt(st.nextToken())){
                case 1:
                    deque.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case 2:
                    deque.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case 3:
                    if(deque.isEmpty()){
                        sb.append(-1).append("\n");
                    }else {
                        sb.append(deque.pollFirst()).append("\n");
                    }
                    break;
                case 4:
                    if(deque.isEmpty()){
                        sb.append(-1).append("\n");
                    }else {
                        sb.append(deque.pollLast()).append("\n");
                    }
                    break;
                case 5:
                    sb.append(deque.size()).append("\n");
                    break;
                case 6:
                    if(deque.isEmpty()){
                        sb.append(1).append("\n");
                    }else {
                        sb.append(0).append("\n");
                    }
                    break;
                case 7:
                    if(deque.isEmpty()){
                        sb.append(-1).append("\n");
                    }else {
                        sb.append(deque.peekFirst()).append("\n");
                    }
                    break;
                case 8:
                    if(deque.isEmpty()){
                        sb.append(-1).append("\n");
                    }else {
                        sb.append(deque.peekLast()).append("\n");
                    }break;
            }
        }

        System.out.println(sb);

    }
}