package com.ssafy.study;

import java.io.*;

public class BOJ_1676 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());	
		int zeroCnt = 0;
		
		while (n >= 5) {
			zeroCnt += n / 5;
			n /= 5;
		}
		
		System.out.println(zeroCnt);
	}
}
