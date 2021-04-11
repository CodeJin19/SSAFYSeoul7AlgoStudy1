package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 기타리스트_BJ1495 {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int []V = new int[N+1];
		st = new StringTokenizer(in.readLine());
		for(int i = 1; i<=N; i++) {
			V[i] = Integer.parseInt(st.nextToken());
		}
		
		boolean dp [][] = new boolean[N+1][M+1];
		
		if(S-V[1]>= 0) dp[1][S-V[1]] = true;
		if(S+V[1]<= M) dp[1][S+V[1]] = true;
		
		for(int i = 2; i<=N; i++) {
			for(int j = 0; j<=M; j++) {
				if(dp[i-1][j]) {
					if(j-V[i] >= 0) dp[i][j-V[i]] = true;
					if(j+V[i] <= M) dp[i][j+V[i]] = true;
				}
			}
		}
		
		int max = -1;
		for(int i = 0; i<=M; i++) {
			if(dp[N][i])
				max = i;
		}
		System.out.println(max);
		
	}
}
