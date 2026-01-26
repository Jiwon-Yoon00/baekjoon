import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String P = br.readLine();
        
        if (kmp(S, P)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    static int[] makePi(String p){
        int m = p.length();
        int[] pi = new int[m];
        
        int j = 0;
        
        for(int i = 1; i < m; i++){
            while(j > 0 && p.charAt(i) != p.charAt(j)){
                j = pi[j-1];
            }

            if(p.charAt(i) == p.charAt(j)){
                pi[i] = ++j;
            }
        }
        return pi;
    }

    static boolean kmp(String s, String p){
        int[] pi = makePi(p);
        int n = s.length();
        int m = p.length();
        int j = 0;

        for(int i = 0; i < n; i++){
            while(j > 0 && s.charAt(i) != p.charAt(j)){
                j = pi[j-1];
            }

            if(s.charAt(i) == p.charAt(j)){
                j++;
            }

            if(j == m){
                return true;
            }
        }

        return false;
    }
}