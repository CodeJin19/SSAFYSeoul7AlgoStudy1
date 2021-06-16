package com.ssafy.study;

import java.io.*;

public class BOJ_1436 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int cnt = 1;
		int num = 666;
		
		while (cnt != n) {
			if (String.valueOf(++num).contains("666"))
				cnt++;
		}
		
		System.out.println(num);
	}

}
