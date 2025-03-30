import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++ ) {
            int x = Integer.parseInt(br.readLine());
            if(x > 0){
                maxHeap.add(x);
            }else {
                if(maxHeap.isEmpty()){
                    System.out.println(0);
                }else {
                    System.out.println(maxHeap.poll());
                }
            }
        }
    }
}