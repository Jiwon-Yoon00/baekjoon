import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String, Integer> map = new HashMap<>(); 
        
        for(String[] line: clothes){
           String ty = line[1];
            
            map.put(ty, map.getOrDefault(ty, 0) + 1);   
        }
    
        for(String value: map.keySet()){
            answer *= (map.get(value) + 1);
            
        }
        return (answer - 1);
    }
}