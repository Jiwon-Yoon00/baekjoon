class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int len = schedules.length;
        int answer = len;
        
       
        int curDay = startday;
        
        for(int i = 0; i < len; i++){
            
            int workTime  = convertTime(schedules[i]); // 출근희망 시각
            
            int day = startday;
            for(int j = 0; j < 7; j++){
                if(day == 6 || day == 7){ // 주말이면 건너뛰기
                    day = (day % 7) + 1;
                    continue;
                }
                
               day = (day % 7) + 1; // 다음 날
                
                int realTime  = convertTime(timelogs[i][j]); // 실제 출근한 시각
                
                if(realTime > workTime + 10){ // 실제출근 한 시간이 더 느리면
                    answer--;
                    break;
                }
                
            }
            
        }
        
        return answer;
    }
    
    public int convertTime(int time){
        String str = String.valueOf(time);
        int len = str.length();
        int minutes = Integer.parseInt(str.substring(len - 2));
        int hour = Integer.parseInt(str.substring(0, len - 2)) * 60;

        return hour + minutes;
    }
}

