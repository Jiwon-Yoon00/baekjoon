import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        
        String str = String.valueOf(n);
        char[] array = str.toCharArray();

        for (int i = 0; i < array.length; i++) {
            answer += array[i] - '0'; // 문자에서 '0' 빼서 정수로 변환
        }
     
        return answer;
    }
}
