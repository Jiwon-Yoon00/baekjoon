class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        
        int row = wallpaper.length ; 
        int col = wallpaper[0].length();
        
        String[][] map = new String[row][col];
        
        // 2차원 배열에 맵 입력하기
        for(int i = 0; i < row; i ++){
            for(int j = 0; j < col; j ++){
                String[] str = wallpaper[i].split("");
                map[i][j] = str[j];
            }
        }

        int left = Integer.MAX_VALUE, top = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE, down = Integer.MIN_VALUE;
        
        // 가장 왼쪽에 있는 파일 찾기 - 가로 좌표
        // -> #을 찾아야하는데, j값이 가장 작은거
        for(int i = 0; i < row; i++){
            //map을 하나하나 이동하면서 #을 찾음
            for(int j = 0; j < col; j++){
                if(map[i][j].equals("#")){
                    if(top > i){ //top이 작아야 하는 거 맞아. top이 더 작을 경우 바꿔줘. ㄱ
                        top = i;
                    }
                    
                    if(left > j){
                        left = j;
                    }
                    
                    if(down < i + 1){
                        down = i + 1;
                    }
                    
                    if(right < j + 1) {
                        right = j + 1;
                    }
                }
            }
        }
        
        answer[0] = top;
        answer[1] = left;
        answer[2] = down;
        answer[3] = right;
        
        return answer;
    }
}