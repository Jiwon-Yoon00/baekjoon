class Solution {
    public int solution(int M, int N) {
        int answer = 0;
        /*
        M-1번 만큼 자른다음에 
        N -1 * 2번 만큼 자름
        
        */
        
        answer = (M -1) + (N - 1) * M; 
        return answer;
    }
}