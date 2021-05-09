package com.ssafy.study;

import java.io.*;
import java.util.regex.Pattern;

public class BOJ_1013 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String pattern = "(100+1+|01)+";
		
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			boolean regex = Pattern.matches(pattern, str);
			
			if (regex) System.out.println("YES");
			else System.out.println("NO");
		}
	}

}
