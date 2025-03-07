import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import static java.lang.Math.sqrt;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(), " ");
            LinkedList<int[]> q = new LinkedList<>();

            for (int j = 0; j < N; j++) {
                q.offer(new int[] { j, Integer.parseInt(st.nextToken()) });
            }

            int count = 0;

            while (!q.isEmpty()){
                int[] front = q.poll();
                boolean isMax = true;

                for (int j = 0; j < q.size(); j++) {
                    if(front[1] < q.get(j)[1]){

                        q.offer(front);

                        for (int k = 0; k < j; k++) {
                            q.offer(q.poll());
                        }

                        isMax = false;
                        break;
                    }
                }

                if(isMax == false) {
                    continue;
                }

                count++;
                if(front[0] == M) {	// 찾고자 하는 문서라면 해당 테스트케이스 종료
                    break;
                }
            }
            sb.append(count).append('\n');
        }
        System.out.println(sb);
    }
}


