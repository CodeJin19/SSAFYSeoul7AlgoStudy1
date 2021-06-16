package com.ssafy.study;

import java.io.*;
import java.util.*;

public class BOJ_5397 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		for (int i = 1; i <= n; i++) {
			String input = br.readLine();
			StringBuilder sb = new StringBuilder();
			Stack<Character> left = new Stack<>();
			Stack<Character> right = new Stack<>();
			
			for (int j = 0; j < input.length(); j++) {
				switch(input.charAt(j)) {
				case '<':
					if (!left.isEmpty())
						right.push(left.pop());
					break;
				case '>':
					if (!right.isEmpty())
						left.push(right.pop());
					break;
				case '-':
					if (!left.isEmpty()) 
						left.pop();
					break;
				default:
					left.push(input.charAt(j));
				}
			}
			
			while (!left.isEmpty()) right.push(left.pop());
			while (!right.isEmpty()) sb.append(right.pop());
			
			System.out.println(sb);
		}
	}

}
