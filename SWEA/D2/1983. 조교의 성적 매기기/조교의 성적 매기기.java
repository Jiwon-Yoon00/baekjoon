import java.util.*;
import java.io.*;

class Solution
{
static int n;
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
            
        	String[] str = br.readLine().split(" ");
            n = Integer.parseInt(str[0]);
            int K = Integer.parseInt(str[1]);
            ArrayList<Pair> list = new ArrayList<>();
            list.add(new Pair("A+", n, 0));
            list.add(new Pair("A0", n, 1));
           	list.add(new Pair("A-", n, 2));
           	list.add(new Pair("B+", n, 3));
            list.add(new Pair("B0", n, 4));
           	list.add(new Pair("B-", n, 5));
            list.add(new Pair("C+", n, 6));
            list.add(new Pair("C0", n, 7));
           	list.add(new Pair("C-", n, 8));
            list.add(new Pair("D0", n, 9));
                     
                     
            double[] students = new double[n];
            double[] ranking = new double[n];         
            for(int i = 0; i < n; i++){
                
                String[] scores = br.readLine().split(" ");
                
                double midterm = Integer.parseInt(scores[0]) * 0.35;
                double finalterm = Integer.parseInt(scores[1]) * 0.45;
                double assignment = Integer.parseInt(scores[2]) * 0.2; 
                double mean = (midterm+ finalterm +assignment) / 3;

                students[i] = mean;
                ranking[i] = mean;
            }
           	int cur_num = 0;          
            Arrays.sort(ranking);
             for(int i = n - 1; i >= 0; i--){
                 
                Pair pair = list.get(cur_num);        
                
             	if(Math.abs(ranking[i] - students[K - 1]) < 1e-9){
                    System.out.println("#" + test_case + " " + pair.name);
                    break;
                }else{
                	pair.decrease();
                }
             if(pair.num == 0) cur_num++;
             }
        }
	}
}

class Pair{
	String name;
    int num; // 몇 번 줄 수 있는지
    int index;

    Pair(String name, int num, int index) {
        this.name = name;
        this.num = num / 10;
        this.index = index;
    }
    
    public void decrease(){
    	num--;
    }

}