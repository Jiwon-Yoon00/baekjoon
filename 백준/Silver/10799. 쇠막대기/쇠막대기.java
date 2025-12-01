import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] line = br.readLine().split("");
        
        ArrayDeque<String> stack = new ArrayDeque<>();
         int answer = 0;
        for(int i = 0; i < line.length; i ++){
            if(line[i].equals("(")){
                stack.push("(");
            }else{
                stack.pop();
                
                if(line[i-1].equals("(")){
                    answer += stack.size();
                }else{
                        answer+=1;
                }
            }
        }
        System.out.println(answer);
    }
}