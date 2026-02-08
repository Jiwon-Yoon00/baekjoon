import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        int n = nums.length / 2;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int value: nums){
            map.put(value, map.getOrDefault(map.get(value), 0) + 1);
        }
        
        if(map.size() >= n){
            return n;
        }else{
            return map.size();
        }

    }
}