import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        HashMap <Integer, Integer> hashMap = new HashMap<>();

        int[] origin = new int[N];	// 원본 배열
        int[] sorted = new int[N];	// 정렬 할 배열

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            origin[i] = sorted[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sorted);

        int index = 0;
        for (int val: sorted){
            if(!hashMap.containsKey(val)){
                hashMap.put(val, index);
                index ++;
            }
        }


        for (int i = 0; i < N; i++) {
            sb.append(hashMap.get(origin[i])).append(" ");
        }

        System.out.println(sb);
    }
}