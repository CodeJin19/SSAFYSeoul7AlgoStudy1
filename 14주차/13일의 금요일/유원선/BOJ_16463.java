package com.ssafy.study;

import java.io.*;

public class BOJ_16463 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] day = new int[] {0,31,28,31,30,31,30,31,31,30,31,30,31};
		
		int n = Integer.parseInt(br.readLine());
		int d = 4, res = 0;
		for (int i = 2019; i <= n; i++) {
			if (isRight(i)) day[2] = 29;
			else day[2] = 28;
		
			for (int month = 1; month <= 12; month++) {
				while (true) {
					d += 7;
					if (d == 13) res++;
					if (d > day[month]) {
						d -= day[month];
						break;
					}
				}
			}
		}
		
		System.out.println(res);
	}
	
	static boolean isRight(int year) {
		if (year % 400 == 0) return true;
		else if (year % 100 != 0 && year % 4 == 0) return true;
		
		return false;
	}

}
