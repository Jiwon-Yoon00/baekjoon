import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int f = 0; f < commands.length; f++){
            int i = commands[f][0];
            int j = commands[f][1];
            int k = commands[f][2];
            
            int[] temp = new int[j - i + 1];
            int idx = 0;
            for(int s = i; s <= j; s++){
                temp[idx++] = array[s-1]; 
            }
            idx = 0;
            Arrays.sort(temp);
            
            answer[f] = temp[k-1];
            
        }
        return answer;
    }
}