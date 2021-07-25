package week23;

import java.io.*;
import java.util.*;

public class 옥상정원꾸미기_BJ6198 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		Stack<Integer> building = new Stack<>();
		long sum = 0;
		for(int i = 0; i<N; i++) {
			int height = Integer.parseInt(in.readLine());
			while(!building.isEmpty() && building.peek() <= height) 
				building.pop();
			
			sum += building.size();
			building.add(height);
		}
		
		System.out.println(sum);
	}
}
// 10 3 7 4 12 2
// 0 1 1 2 0 1

// 4 7 3 10
// 제일 위