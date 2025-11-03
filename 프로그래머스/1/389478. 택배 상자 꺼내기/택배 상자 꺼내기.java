class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        
        // 몇층에 있는지
        int floor = ((num - 1) / w) + 1;
        
        // 몇번째에 있는지 - 홀수층이면 왼에서 오, 짝수층이면 오에서 왼
        int position = 0;
        
        if(floor % 2 == 1 ){
            position = ((num - 1) % w);
        }else{
            position = w - ((num - 1) % w) - 1; 
        }
        
        
    
        
        // 맨위에 있는 애들이 어디에 있는지
        int top = n;
        while(top > 0){
            
            int top_floor = ((top - 1) / w) + 1; 
            int top_position = 0; 
            
            if(top_floor % 2 == 1 ){
                top_position = ((top - 1) % w); 
            }else{
                top_position = w - ((top - 1) % w) - 1;  
            }
            
            if(top_position == position){
                answer  = top_floor - floor  + 1;
                break;
            }
            
            top--;
        }
        
        
        return answer;
        
        
    }
}