class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {

        // schedules 10분 더한 배열
        int[] convertSchedules = new int[schedules.length];
        for(int i = 0; i < schedules.length; i++){
            int hour = schedules[i] / 100;
            int minutes = schedules[i] % 100;
            minutes += 10;
            if(minutes >= 60){
                hour += minutes / 60;
                minutes %= 60;
            }
            convertSchedules[i] = hour * 100 + minutes;
        }

        int answer = 0;
        int day0 = startday - 1;  // 0~6 범위

        for (int i = 0; i < schedules.length; i++) {
            boolean success = true;
            for (int j = 0; j < timelogs[i].length; j++) {

                // j일 후 요일 계산
                int dDay = (day0 + j) % 7;

                // 토요일(5), 일요일(6) 건너뛰기
                if(dDay == 5 || dDay == 6) continue;

                if (convertSchedules[i] < timelogs[i][j]) {
                    success = false;
                    break;
                }
            }
            if (success) answer++;
        }
        return answer;
    }
}

