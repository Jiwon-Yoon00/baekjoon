import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        // 각 배열에 각 종류마다 몇 개 있는 지 저장
        // 종류의 수도 맞추고 갯수도 맞추고
        // 종류의 수가 가장 큰 것으로 정렬 하면됨
        
        int max = 0;
        for (int t : tangerine) {
            max = Math.max(max, t);
        }

        
        int[] type = new int[max + 1];

        for (int t : tangerine) {
            type[t]++;
        }
        
        Arrays.sort(type);
        // 기본적으로 오름차순이니까 뒤에서부터 접근
        for (int i = type.length - 1; i >= 0; i--) {
            if (type[i] == 0) continue;
            k -= type[i];
            answer++;
            if (k <= 0) break;
        }
        
        return answer;
    }
}