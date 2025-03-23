import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static boolean[] check;
    static int[][] arr;
    static int node, line;
    static Queue<Integer> q = new LinkedList<>();
    static int count = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        node = Integer.parseInt(br.readLine());
        line = Integer.parseInt(br.readLine());

        arr = new int[node+1][node+1];
        check = new boolean[node+1];

        for (int i = 0; i < line; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = arr[b][a] = 1; // 인접행렬
        }

        dfs(1);

        System.out.println(count-1);

    }

    public static void dfs(int start){
        check[start] = true;
        count++;

        for (int i = 0; i <= node ; i++) {
            // arr[start][i] == 1 은 start 노드와 i노드가 연결되었다는 뜻.
            // check가 false라면 아직 순회하지 않았다는 뜻
            if(arr[start][i] ==  1 && !check[i]){
                // start와 연결된 다음 노드로 가서 다시 check를 true로 만듦
                dfs(i);
            }
        }
    }
}