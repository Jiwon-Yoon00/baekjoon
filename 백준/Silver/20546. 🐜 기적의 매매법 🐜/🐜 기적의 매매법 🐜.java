import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int cash;
    static int[] stocks;
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        cash = Integer.parseInt(br.readLine());
        stocks = new int[14];
        String[] lines = br.readLine().split(" ");
        
        for(int i = 0; i < 14; i++){
            stocks[i] = Integer.parseInt(lines[i]);
        }

        int a = junhun();
        int b = sungmin();

        if(a > b){
            System.out.println("BNP");
        }else if(a < b) {
             System.out.println("TIMING");
        }else{
            System.out.println("SAMESAME");
        }
    }

    static int junhun(){
        int cnt = 0;
        int cur = cash;
        for(int v: stocks)
            {
                if(cur < v) continue;
                cnt += cur / v; // 매수한 주식 수
                cur = cur % v; // 남은 돈
            }
        return stocks[stocks.length -1 ] * cnt + cur;
    }

    static int sungmin(){
        int blue = 0;
        int red = 0;
        int prev = stocks[0];
        int cnt = 0;
        int cur  =  cash;
        
        for(int v: stocks){
            if(prev < v){
                red++;
                blue = 0;
                //System.out.println("red: " + red);
            } else if(prev > v){
                blue++;
                red = 0;
                //System.out.println("blue " + blue);
            }

            prev = v;

            if(red >= 3){
                if(cnt > 0){
                    cur = v * cnt;
                    cnt = 0; // 전량매도
                    //System.out.println("매도: " + cnt + " "+cur);
                }
            }else if(blue >= 3){
                if(cur < v) continue;
                cnt += (cur / v); // 매수한 주식 수
                //System.out.println("돈: " + cash + " " + v);
                cur = cur % v; // 남은 돈
                //System.out.println("매수: " + cnt + " " + cur);
            }
        }

        return stocks[stocks.length - 1] * cnt + cur;
    }
}