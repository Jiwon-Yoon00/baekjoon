import java.util.*;

class Solution {
    public int solution(int[] array, int n) {
        int num = 0;
        int distance = 0;
        int min = Integer.MAX_VALUE;
        
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < array.length; i++){
            distance = Math.abs(n - array[i]);
            
            if (distance < min) {
                min = distance;
                list.clear();        
                list.add(array[i]);
            } else if (distance == min) {
                list.add(array[i]);      
            }
        
        }
        
        Collections.sort(list);
        
        
        return list.get(0);
    }
}