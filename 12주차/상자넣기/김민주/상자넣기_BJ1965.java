package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// LIS
public class 상자넣기_BJ1965 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int [] box = new int[n];
		int [] dp = new int[n];
		int max = 0;
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i = 0; i<n; i++) {
			box[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0; i<n; i++) {
			dp[i] = 1;
			for(int j = 0; j<i; j++) {
				if(box[i] > box[j]) {
					if(dp[i] < dp[j]+1) dp[i] = dp[j]+1;
				}
			}
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}
	
}
