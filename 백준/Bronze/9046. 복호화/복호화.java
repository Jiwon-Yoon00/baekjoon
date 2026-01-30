import java.util.*; import java.lang.*; import java.io.*; 
class Main { 
    public static void main(String[] args) throws Exception{ 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int T = Integer.parseInt(br.readLine()); 
        while(T-- > 0){ int[] arr = new int[26]; String str = br.readLine().replace(" ", ""); 
                       char[] line = str.toCharArray(); 
                       int max = Integer.MIN_VALUE; 
                       for(int i = 0; i < line.length; i++){ arr[line[i] - 'a'] ++; } 
                       for(int i = 0; i < arr.length; i++){ if(max < arr[i]) max = arr[i]; 
                                                          } int count = 0; int idx = 0;  
                       for(int i = 0; i < arr.length; i++ ){ if(max == arr[i]){ count++; idx = i; }  } if(count > 1){ System.out.println("?"); }else{ System.out.println((char)('a' + idx)); } } } }