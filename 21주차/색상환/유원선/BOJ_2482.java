package com.ssafy.study;

import java.io.*;

public class BOJ_2482 {
	
	static final int MOD = 1000000003;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		
		int[][] dp = new int[n+1][n+1];
		for (int i = 1; i <= n; i++) 
			dp[i][1] = i;
		
		for (int i = 4; i <= n; i++) {
			for (int j = 2; j <= i/2; j++) {
				dp[i][j] = (dp[i-1][j] + dp[i-2][j-1]) % MOD;
			}
		}
		
		System.out.println(dp[n][k]);
	}

}