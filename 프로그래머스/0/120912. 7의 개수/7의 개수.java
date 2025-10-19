class Solution {
    public int solution(int[] array) {
        int answer = 0;
        char target = '7';
        for(int i =0; i < array.length; i++){
            String str = String.valueOf(array[i]);
            for(int j = 0; j < str.length(); j++){
                if(str.charAt(j) == target){
                    answer ++ ;
                }
            }
        }
        return answer;
    }
}