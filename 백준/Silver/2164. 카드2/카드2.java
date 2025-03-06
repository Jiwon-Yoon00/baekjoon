import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int[] arr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= N ; i++) {
            q.add(i);
        }

        if(q.size() == 1){
            System.out.println(q.peek());
        }

        while (q.size() != 1){

            q.poll(); // 첫번째 원소 버리기
            if(q.size() == 1){
                System.out.println(q.peek());
                break;
            }
            // 두번째 원소 뒤로 보내기
            int element = q.poll();
            q.add(element);

        }

    }
}