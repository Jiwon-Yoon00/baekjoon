import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        int n = players.length;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(players[i], i); // 선수 이름 -> 인덱스
        }

        for (String call : callings) {
            int idx = map.get(call);       // 호출된 선수 위치
            if (idx == 0) continue;        // 1등이면 건너뛰기
            
            // 선수 위치 바꾸기
            String frontPlayer = players[idx - 1];
            players[idx - 1] = call;
            players[idx] = frontPlayer;

            // HashMap 업데이트
            map.put(call, idx - 1);
            map.put(frontPlayer, idx);
        }

        return players;
    }
}
