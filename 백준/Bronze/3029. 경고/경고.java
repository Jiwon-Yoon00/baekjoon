import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] current = br.readLine().split(":");
        int currentTime = 0;
        currentTime += Integer.parseInt(current[0]) * 3600;
        currentTime += (Integer.parseInt(current[1]) * 60);
        currentTime += Integer.parseInt(current[2]);

        int waitTime = 0;
        String[] wait = br.readLine().split(":");
        waitTime += (Integer.parseInt(wait[0]) * 3600);
        waitTime += (Integer.parseInt(wait[1]) * 60);
        waitTime += Integer.parseInt(wait[2]);

        int result = 0;
        if(waitTime > currentTime){
            result = waitTime - currentTime;
        }else if(waitTime < currentTime){
            result = 24 * 3600 - currentTime + waitTime;
        }else{
            result = 24 * 3600;
        }
        int hour = result / 3600;
        int mimutes = result % 3600 / 60; 
        int second = result % 3600 % 60;
        
        System.out.printf("%02d:%02d:%02d", hour,mimutes,second);
    }
}