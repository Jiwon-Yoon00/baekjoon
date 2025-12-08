import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name;
        Map<String, Integer> map = new HashMap<>();
       int total = 0;
        
        while((name = br.readLine()) != null){
            if(name.isEmpty()) continue;
            map.put(name, map.getOrDefault(name, 0) + 1);
            total++;
        }
        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for(String key : list){
            int count = map.get(key);
            double rate = (double) count*100 / total;
            sb.append(key).append(" ").append(String.format("%.4f",rate)).append("\n");
        }
        System.out.print(sb);
    }
}