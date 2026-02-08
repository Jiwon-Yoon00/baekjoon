import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < participant.length; i++){
            map.put(participant[i], map.getOrDefault(participant[i], 0) + 1);
        }
        
        
        for(int i = 0; i < completion.length; i++){
            // map에서 key 값이 가지고 있는 value에서 1씩 뺴기
            map.put(completion[i], map.get(completion[i]) - 1);
        }
        
        for (String key : map.keySet()) {
            if (map.get(key) > 0) answer = key;
        }
        return answer;
    }
}