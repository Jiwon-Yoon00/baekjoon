
import java.util.*;
import java.io.*;

public class Solution {

	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int[][] arr;
	static Set<String> set;
	static String str;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			arr = new int[4][4];
			for(int i = 0; i < 4; i ++) {
				String[] str = br.readLine().split(" ");
				for(int j = 0; j < 4; j ++) {
					arr[i][j] = Integer.parseInt(str[j]);
				}
			}
			set = new HashSet<>();
			for(int i = 0; i < 4; i ++) {
				for (int j = 0; j < 4; j ++) {
					dfs(i, j, "" + arr[i][j]);
					str = "";
				}
			}
			

			System.out.println("#" + test_case + " " + set.size());
		}
	}
	
	public static void dfs(int x, int y, String path) {
        if (path.length() == 7) {
            set.add(path);
            return;
        }
		
		for(int i = 0; i < 4; i ++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < 0 || ny < 0 || nx >= 4 || ny >= 4) continue;
			dfs(nx, ny, path + arr[nx][ny]);
		}
	}
	
	
}