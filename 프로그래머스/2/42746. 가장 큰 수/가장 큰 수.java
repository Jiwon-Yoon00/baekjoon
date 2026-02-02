import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        // 1. int 배열 → String 배열
        String[] arr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return (b + a).compareTo(a + b);
            }
        });
            
        if(arr[0].equals("0")){
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.length; i++){
            sb.append(arr[i]);
        }
        
        return sb.toString();

    
    }
}
