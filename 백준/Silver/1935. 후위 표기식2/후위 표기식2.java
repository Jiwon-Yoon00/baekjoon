import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        HashMap<Character, Integer> map = new HashMap<>();
        ArrayDeque<Double> st = new ArrayDeque<>();

        for(int i = 0; i < N; i++){
            map.put((char)(65 + i) ,Integer.parseInt(br.readLine()));
        }
        
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(c != '*' && c != '+' && c != '/' && c != '-'){
                st.push((double)map.get(c));
            }else{
                double x = st.pop();
                double y = st.pop();
                //System.out.println("x: " + x + " y:" + y);
                switch (c) {
                    case '/':
                        st.push(y / x);
                        break;
                    case '*':
                        st.push(y * x);
                        break;
                     case '+':
                        st.push(y + x);
                        //System.out.println(st.peek());
                        break;
                     case '-':
                        st.push(y - x);
                        break;
                }
                 
            }
        }
        System.out.printf("%.2f", st.pop());
    }
}