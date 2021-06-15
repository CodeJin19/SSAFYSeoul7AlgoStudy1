package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 포도주시식_BJ2156 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int [] p = new int[N+1];
		int [] dp = new int[N+1];
		for(int i = 1; i<=N; i++) {
			p[i] = Integer.parseInt(in.readLine());
		}
		dp[1] = p[1];
		if(N>1) dp[2] = p[1]+p[2];
		for(int i = 3; i<=N; i++) {
			dp[i] = Math.max(dp[i-1], Math.max(dp[i-2]+p[i], dp[i-3]+p[i-1]+p[i]));
//							 (x 2 x) , 				(1 x 3),    (+ x 2 3)
		}
		System.out.println(dp[N]);
	}
}
