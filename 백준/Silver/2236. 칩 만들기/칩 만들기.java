import java.io.*;
import java.util.*;

public class Main {
    static class Part implements Comparable<Part> {
        int importance;
        int index;
        Part(int importance, int index) {
            this.importance = importance;
            this.index = index;
        }
        @Override
        public int compareTo(Part o) {
            return o.importance - this.importance; // 내림차순
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Part[] parts = new Part[N];
        for (int i = 0; i < N; i++) {
            int imp = Integer.parseInt(st.nextToken());
            parts[i] = new Part(imp, i + 1); // 1-based
        }

        Arrays.sort(parts); // 중요도 내림차순

        int[] lines = new int[K]; // 각 전원 선에 연결된 부품 번호
        int[] used = new int[N + 1]; // 부품 연결 상대, 1-based

        int idx = 0;
        // 가장 큰 부품 우선 연결
        for (int i = 0; i < K && idx < N; i++) {
            lines[i] = parts[idx].index;
            used[parts[idx].index] = parts[idx].index; // 혼자 연결
            idx++;
        }

        // 남은 부품 2개씩 묶어서 연결
        int lineIdx = 0;
        while (idx + 1 < N) {
            int a = parts[idx].index;
            int b = parts[idx + 1].index;

            // 다음 빈 선 찾기
            while (lineIdx < K && lines[lineIdx] != 0) {
                lineIdx++;
            }
            if (lineIdx == K) break;

            lines[lineIdx] = a;
            used[a] = b;
            used[b] = a;

            idx += 2;
            lineIdx++;
        }

        // 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < K; i++) {
            sb.append(lines[i]).append("\n");
        }
        for (int i = 1; i <= N; i++) {
            sb.append(used[i]).append("\n");
        }
        System.out.print(sb);
    }
}
