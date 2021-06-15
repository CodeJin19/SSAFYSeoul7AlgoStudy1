package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 영화감독숌_BJ1436 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int cnt = 0;
		int num = 666;
		while(true) {
			if(Integer.toString(num).contains("666")) cnt++;
			if(cnt == n) break;
			num++;
		}
		System.out.println(num);
	}
}
