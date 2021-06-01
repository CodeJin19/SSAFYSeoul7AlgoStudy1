package com.ssafy.study;

import java.io.*;

public class BOJ_2156 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] glass = new int[10001];
		int[] dp = new int[10001];
		
		for (int i = 1; i <= n; i++) 
			glass[i] = Integer.parseInt(br.readLine());
		
		dp[1] = glass[1];
		dp[2] = glass[1] + glass[2];
		
		for (int i = 3; i <= n; i++) {
			dp[i] = Math.max(dp[i-3] + glass[i-1] + glass[i], dp[i-2] + glass[i]);
			dp[i] = Math.max(dp[i], dp[i-1]); // 현재 포도주를 마시지 않았을 때도 비교
		}
		
		System.out.println(dp[n]);
	}
}
