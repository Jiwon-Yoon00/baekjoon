import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int N;
    static int len;
    static char[] result;
    static char[] ch;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < N; i++){
            ch = br.readLine().toCharArray();
            len = ch.length;
            result = new char[len];
            Arrays.sort(ch);
            visited = new boolean[len];
            dfs(0);
        }

        System.out.println(sb);
    }

    static void dfs(int depth){
   
        if(depth == len){
      
            for(int i = 0; i < len; i++){
                sb.append(result[i]);
            }
            sb.append("\n");
            return;
        }

        for(int i = 0; i < len; i++){
            
            if(visited[i]) continue;
           
            if(i > 0 && ch[i] == ch[i-1] && !visited[i - 1]) continue;
            result[depth] = ch[i];
            
            visited[i] = true;
            
            dfs(depth + 1);
            
            visited[i] = false;
        }
    }
}
