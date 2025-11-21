

import java.util.*;
import java.io.*;

class Main
{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//int N = Integer.parseInt(br.readLine());
		
		String[] a = br.readLine().split(" ");
		int ax = Integer.parseInt(a[0]);
		int ay = Integer.parseInt(a[1]);
		int az = Integer.parseInt(a[2]);
		
		String[] b = br.readLine().split(" ");
		int cx = Integer.parseInt(b[0]);
		int cy = Integer.parseInt(b[1]);
		int cz = Integer.parseInt(b[2]);
		

		int bx = cx - az;
		int by = cy/ay;
		int bz = cz - ax;
		
		System.out.println(bx + " " + by + " " + bz);
		
	}
}