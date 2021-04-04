package com.ssafy.study;

import java.io.*;

public class BOJ_10422 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		long[] dp = new long[5001];
		dp[0] = 1;
		dp[2] = 1;
		dp[4] = 2;
		
		for (int i = 6; i <= 5000; i += 2) {
			for (int j = 0; j <= i - 2; j += 2) {
				dp[i] += dp[j] * dp[i - 2 - j];
				dp[i] %= 1000000007;
			}
		}
		
		for (int t = 0; t < T; t++) {
			int L = Integer.parseInt(br.readLine());
			
			if (L % 2 != 0) System.out.println(0);
			else System.out.println(dp[L]);
		}
	}
}