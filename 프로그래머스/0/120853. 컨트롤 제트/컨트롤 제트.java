import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        String[] str = s.split(" ");
        int size = str.length;
        for(int i = 0; i < size; i++ ){
           
            if(str[Math.min(i + 1, size -1)].equals("Z")) continue;
            if(str[i].equals("Z")) continue;
            answer += Integer.parseInt(str[i]);
        }
        
        return answer;
    }
}