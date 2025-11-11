import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int test_case = 1; test_case <= 10; test_case++) {
            int N = Integer.parseInt(br.readLine());
            String expr = br.readLine();

            ArrayDeque<Character> opStack = new ArrayDeque<>();
            StringBuilder postfix = new StringBuilder();

            for (int i = 0; i < N; i++) {
                char c = expr.charAt(i);
                if (c == '+' || c == '*') {
                    while (!opStack.isEmpty() && precedence(opStack.peek()) >= precedence(c)) {
                        postfix.append(opStack.pop());
                    }
                    opStack.push(c);
                } else { // 숫자
                    postfix.append(c);
                }
            }

            while (!opStack.isEmpty()) {
                postfix.append(opStack.pop());
            }

            // 2. 후위표기 계산
            ArrayDeque<Integer> calc = new ArrayDeque<>();
            for (int i = 0; i < postfix.length(); i++) {
                char c = postfix.charAt(i);
                if (c == '+') {
                    int b = calc.pop();
                    int a = calc.pop();
                    calc.push(a + b);
                } else if (c == '*') {
                    int b = calc.pop();
                    int a = calc.pop();
                    calc.push(a * b);
                } else {
                    calc.push(c - '0'); 
                }
            }

            System.out.println("#" + test_case + " " + calc.pop());
        }
    }

    private static int precedence(char op) {
        if (op == '*') return 2;
        if (op == '+') return 1;
        return 0;
    }
}
