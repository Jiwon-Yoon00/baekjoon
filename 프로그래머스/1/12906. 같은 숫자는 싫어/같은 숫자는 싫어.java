import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        Deque<Integer> q = new ArrayDeque<>();
        
        for(int i: arr){
            if(!q.isEmpty() && q.peekLast().equals(i)) continue;
            q.offer(i);
        }
        
        
        int[] answer = new int[q.size()];
        
       for(int i = 0; i < answer.length; i++){
           answer[i] = q.poll();
       }

        return answer;
    }
}