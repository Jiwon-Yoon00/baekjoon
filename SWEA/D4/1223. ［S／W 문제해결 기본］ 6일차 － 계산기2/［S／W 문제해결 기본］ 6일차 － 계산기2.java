
import java.io.*;
import java.util.*;

public class Solution {


    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("src/codingTest/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
               
        
        for (int test_case = 1; test_case <= 10; test_case++) {
            int N = Integer.parseInt(br.readLine());
            String expr = br.readLine();
            String str = "";
            ArrayDeque<Character> opStack = new ArrayDeque<>();
            
            for(int i = 0; i < N; i++) {
            	char c = expr.charAt(i);
            	//"34+56*+7+"
            	if(c == '+' || c == '*') {
            		while(!opStack.isEmpty() && (precedence(opStack.peek()) >= precedence(c))) {
            			str += opStack.pop();
            		}
            		opStack.push(c);
            	}else {
            		str += c;
            	}
            }
            
            while (!opStack.isEmpty()) {
                str += opStack.pop();
            }
            
            
            // 계산
            ArrayDeque<Integer> answer = new ArrayDeque<>();
            for(int i = 0; i < str.length(); i ++) {
            	char c = str.charAt(i);
            	
            	if(c == '+') {
            		int a = answer.pop();
            		int b = answer.pop();
            		answer.push(a+b);
            	}else if(c == '*') {
            		int a = answer.pop();
            		int b = answer.pop();
            		answer.push(a*b);
            	}else {
            		answer.push(c - '0');
            	}
            }
            System.out.println("#" + test_case + " " + answer.pop());
        }
    }
    
    private static int precedence(char op) {
        if (op == '*') return 2;
        if (op == '+') return 1;
        return 0;
    }

}