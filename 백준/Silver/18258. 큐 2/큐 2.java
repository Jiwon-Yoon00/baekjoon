import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Queue<String> queue = new LinkedList<>();
        StringTokenizer st;

        String last = "-1";
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine()," ");
            String command = st.nextToken();

            switch (command){
                case "push":
                    String str = st.nextToken();
                    last = str;
                    queue.add(str);
                    break;
                case "pop":
                    if(queue.isEmpty()){
                        sb.append(-1).append("\n");
                    }else {
                        sb.append(queue.poll()).append("\n");
                    }
                    break;
                case "size":
                    sb.append(queue.size()).append("\n");
                    break;
                case "empty":
                    if(queue.isEmpty())  sb.append(1).append("\n");
                    else sb.append(0).append("\n");
                    break;
                case "front":
                    if(queue.isEmpty()){
                        sb.append(-1).append("\n");
                    }else {
                        sb.append(queue.peek()).append("\n");
                    }
                    break;
                case "back":
                    if(queue.isEmpty()){
                        sb.append(-1).append("\n");
                    }else {
                        sb.append(last).append("\n");
                    }
                    break;
            }


        }

        System.out.println(sb);
    }
}