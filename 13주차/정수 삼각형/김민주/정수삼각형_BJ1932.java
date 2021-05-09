package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정수삼각형_BJ1932 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int [][]tri = new int[n][n];
		int [][]dp = new int[n][n];
		int max = 0;
		
		for(int i = 0; i<n; i++) {
			StringTokenizer st = new  StringTokenizer(in.readLine());
			for(int j = 0; j<=i; j++) {
				tri[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[0][0] = tri[0][0];
		
		for(int i = 1; i<n; i++) {
			for(int j = 0; j<=i; j++) {
				if(j == 0) dp[i][j] = tri[i][j] + dp[i-1][j];
				else dp[i][j] = tri[i][j] + Math.max(dp[i-1][j], dp[i-1][j-1]);
			}
		}
		
		for(int j = 0; j<n; j++) {
			max = Math.max(max, dp[n-1][j]);
		}
		
		System.out.println(max);
	}
	
}
