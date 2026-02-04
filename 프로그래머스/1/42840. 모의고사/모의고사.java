import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
       
        int[] one = {1,2,3,4,5};
        int[] two = {2,1,2,3,2,4,2,5};
        int[] three = {3,3,1,1,2,2,4,4,5,5};
        
        int oneScore = 0;
        int twoScore = 0;
        int threeScore = 0;
        
        for (int i = 0; i < answers.length; i++) {
            if (one[i % one.length] == answers[i]) oneScore++;
            if (two[i % two.length] == answers[i]) twoScore++;
            if (three[i % three.length] == answers[i]) threeScore++;
        }
        int max = Math.max(oneScore, Math.max(twoScore, threeScore));
          List<Integer> list = new ArrayList<>();
        if (oneScore == max) list.add(1);
        if (twoScore == max) list.add(2);
        if (threeScore == max) list.add(3);
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}