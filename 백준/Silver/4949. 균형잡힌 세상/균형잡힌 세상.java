import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str;
        while (true) {
            str = br.readLine();
            if (str.equals(".")) {
                break;
            }

            Stack<Character> s = new Stack<>();
            boolean isBalanced = true;

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                if (c == '(' || c == '[') {
                    s.push(c);
                } else if (c == ')') {
                    if (s.empty() || s.peek() != '(') {
                        isBalanced = false;
                        break;
                    }
                    s.pop();
                } else if (c == ']') {
                    if (s.empty() || s.peek() != '[') {
                        isBalanced = false;
                        break;
                    }
                    s.pop();
                }
            }

            // 스택이 비어 있고 중간에 문제 발생하지 않았을 경우만 "yes"
            if (isBalanced && s.empty()) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}