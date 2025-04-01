import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int target  = 1;
        int index = 0;

        while (index < N || !stack.isEmpty()){
            if (index < N && arr[index] == target){
                index++;
                target++;
            } else if (!stack.isEmpty() && stack.peek() == target) {
                stack.pop();
                target++;
            } else if (index < N) {
                stack.push(arr[index++]);
            }else {
                break;
            }
        }

        if (target == N + 1) {
            System.out.print("Nice");
        } else {
            System.out.print("Sad");
        }
    }
}