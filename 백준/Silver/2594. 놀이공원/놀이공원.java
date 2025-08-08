import java.io.*;
import java.util.*;

public class Main {

    // HHMM → 분 변환
    static int toMinutes(int t) {
        return (t / 100) * 60 + (t % 100);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<int[]> list = new ArrayList<>();

        // 입력받기
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new int[]{toMinutes(start), toMinutes(end)}); // 분 단위로 저장
        }

        // 시작 시간 기준 정렬
        list.sort(Comparator.comparingInt(o -> o[0]));

        // 겹치는 구간 병합
        List<int[]> merged = new ArrayList<>();
        int[] cur = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            int[] next = list.get(i);
            if (cur[1] >= next[0]) { // 겹치면
                cur[1] = Math.max(cur[1], next[1]);
            } else { // 안 겹치면 추가
                merged.add(cur);
                cur = next;
            }
        }
        merged.add(cur);

        int maxRest = 0;

        // 하루 시작(10:00) ~ 첫 구간 전
        int dayStart = toMinutes(1000);
        int firstGap = merged.get(0)[0] - 10 - dayStart;
        if (firstGap > 0) maxRest = Math.max(maxRest, firstGap);

        // 구간 사이
        for (int i = 0; i < merged.size() - 1; i++) {
            int gap = merged.get(i + 1)[0] - 10 - (merged.get(i)[1] + 10);
            if (gap > 0) maxRest = Math.max(maxRest, gap);
        }

        // 마지막 구간 후 ~ 하루 종료(22:00)
        int dayEnd = toMinutes(2200);
        int lastGap = dayEnd - (merged.get(merged.size() - 1)[1] + 10);
        if (lastGap > 0) maxRest = Math.max(maxRest, lastGap);

        System.out.println(maxRest);
    }
}
