package com.ssafy.study;

import java.io.*;
import java.util.*;

public class BOJ_6198 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		
		long sum = 0;
		for (int i = 0; i < n; i++) {
			int height = Integer.parseInt(br.readLine());
			while (!stack.isEmpty() && height >= stack.peek())
				stack.pop();
				
			sum += stack.size();
			stack.push(height);
		}
		
		System.out.println(sum);
	}

}
