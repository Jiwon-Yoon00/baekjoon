class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        
        int cur = toSeconds(pos);
        int total = toSeconds(video_len);
        int start = toSeconds(op_start);
        int end = toSeconds(op_end);
        
        
        // 사용자 입력을 하나씩 꺼내서 시간 계산하기
        for(int i=0; i < commands.length; i++){
            String command = commands[i];
            
            if(command.equals("next")){    
                // 2. 10초 더하기
              if(start <= cur && cur < end){
                    cur = end + 10;
                }else{
                   cur += 10;
              }
                
             
                if(start <= cur && cur < end){
                    cur = end;
                }
                
               if(cur > total) cur = total;
        
                    
            } else if(command.equals("prev")){ // 10초 전으로 이동
                
                if(start <= cur && cur < end){
                    cur = end;
                }else{
                    cur -= 10;
                }
                if(start <= cur && cur < end){
                    cur = end;
                }
                
                
                if(cur < 0) cur = 0;
            }
        }
        

        
       return toTime(cur);
    }
    
    private int toSeconds(String time){
        String[] t = time.split(":");
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }
    
    private String toTime(int seconds){
        int mm = seconds / 60;
        int ss = seconds % 60;
        
        return String.format("%02d:%02d", mm, ss);
    }
}