import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Deque<String> stack  = new ArrayDeque<>();
        String[] str = s.split("");
        int len = str.length;
        
        for(int i = 0; i < len; i++){
            if(str[i].equals("(")){
                stack.push(str[i]);
            }else{
                if(stack.isEmpty()){
                    return false;
                }else{
                    String el = stack.pop();
                    if(!el.equals("(")){
                        return false;
                    }
                }
            }
            
        }
        
        if(!stack.isEmpty()){
            return false;
        }


        return answer;
    }
}