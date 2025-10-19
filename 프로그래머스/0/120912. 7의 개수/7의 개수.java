class Solution {
    public int solution(int[] array) {
        String str = "";
        for(int n:array) str += n;
        return str.length() - str.replace("7", "").length();
    }
}