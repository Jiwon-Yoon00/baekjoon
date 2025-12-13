import java.io.*;
import java.util.*;

class Main {
    static boolean[] removed;
    static List<List<Integer>> lists;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        removed = new boolean[N];
        lists = new ArrayList<>();

        for(int i = 0; i < N; i ++){
            lists.add(new ArrayList<>());
        }
       
        StringTokenizer st = new StringTokenizer(br.readLine());
        int root = -1;
        for(int i = 0; i < N; i++){
            int x = Integer.parseInt(st.nextToken());
            if (x == -1) {
                root = i;
            } else {
                lists.get(x).add(i);
            }
        }

        int remove = Integer.parseInt(br.readLine());
        dfs(remove);
  
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (removed[i]) continue;
        
            boolean isLeaf = true;
            for (int child : lists.get(i)) {
                if (!removed[child]) {
                    isLeaf = false;
                    break;
                }
            }
            if (isLeaf) count++;
        }


        System.out.println(count);
    }

    static void dfs(int node) {
        removed[node] = true;
        for (int child : lists.get(node)) {
            dfs(child);
        }
    }
}