import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        //int N = Integer.parseInt(br.readLine());

        int arr[] = {1, 1, 2, 2, 2, 8};

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < arr.length; i++) {
            int x = Integer.parseInt(st.nextToken());
            sb.append(arr[i] - x).append(" ");
        }

        System.out.println(sb);
        //Deque<Integer> deque = new LinkedList<>();
    }
}