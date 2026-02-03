import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(Integer n: nums){
            map.put(n, map.getOrDefault(n, 0) + 1);    
        }
        
        int len = nums.length;
        
        if(len / 2 <= map.size()){
            answer = len / 2;
        }else{
            answer = map.size();
        }
        
        return answer;
    }
}