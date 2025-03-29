import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if(x!=0){
                minHeap.add(x);
            }else {
                Integer y = minHeap.poll();
                if(y == null){
                    System.out.println(0);
                }else {
                    System.out.println(y);
                }
            }
        }

    }
}