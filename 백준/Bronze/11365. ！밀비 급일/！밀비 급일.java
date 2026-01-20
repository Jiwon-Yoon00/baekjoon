import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            String line = br.readLine();
            if(line.equals("END")) break;
            StringBuffer sf = new StringBuffer(line);
            String reversed = sf.reverse().toString();
            sb.append(reversed).append("\n");
        }
        System.out.println(sb);
    }
}