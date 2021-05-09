package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 금요일_BJ16463 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int m[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int cnt = 0;
		int day = 13;
		
		for(int i = 2019; i<=N; i++) {
			if((i%4 == 0 && i %100 != 0) || i%400==0) {
				m[1] = 29;
			}
			else m[1] = 28;
			
			for(int j = 0; j<12; j++) {
				if(day%7 == 4) {
					cnt++;
				}
				day += m[j];
			}
		}
		System.out.println(cnt);
	}
}
