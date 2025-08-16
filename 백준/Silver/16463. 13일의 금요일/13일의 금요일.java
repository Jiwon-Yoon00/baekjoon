import java.io.*;
import java.util.*;

public class Main {
	static int curYear = 2019;
	static int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int res = 0;
		int curDate = 4;

		while(curYear <= N) {
			//System.out.println("현재년도: " + curYear);

			for(int i = 0; i < months.length; i++) {

				if(i == 1){
					isDec(curYear);
				}

				while(curDate < months[i]) { // 다음달로 넘어가야 되는 경우
					//System.out.println("현재 달: " + (i+1) + " 일: " + curDate);

					curDate += 7;
					if(curDate == 13){
						res++;
					}
				}
				curDate = curDate -months[i];
			}
			curYear++;
		}

		System.out.println(res);

		// 2019년 1월 4일 부터 7씩 더해서 count++; 를하는데, curDate 가 13이면 ++
		// 만약 30,31,28일을 넘어가는 경우는 다음 달로 넘어간 것으로 간주
		// 다음달이 30일 가지 있다면 curDate - 30을 빼면 그 다음 금요일이 나옴
		// 몇월 달 인지 확인하고, 윤년인지도 확인
	}

	static void isDec(int year){
		if(year % 400 == 0 || (year % 4 == 0 &&  year % 100 != 0)){
			//System.out.println("윤년입니다");
			months[1] = 29;
			return;
		}
		months[1] = 28;
	}
}
