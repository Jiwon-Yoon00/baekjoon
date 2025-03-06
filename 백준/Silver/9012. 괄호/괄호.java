import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            Stack<Character> stack = new Stack<>();
            boolean isBalanced = true;

            for (int j = 0; j < str.length(); j++) {
                if(str.charAt(j) == '('){ // 열린 괄호면 스택에 삽입
                    stack.add(str.charAt(j));
                } else if (str.charAt(j) == ')') {
                    if(stack.isEmpty()){
                        isBalanced = false;
                        break;
                    }

                    if(stack.peek() == '('){
                        stack.pop();
                    }
                }
            }

            if(stack.isEmpty() && isBalanced){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }
}
