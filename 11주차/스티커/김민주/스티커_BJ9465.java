package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스티커_BJ9465 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(in.readLine());
			int [][] sticker = new int[2][n+2];
			for(int i = 0; i<2; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				for(int j = 2; j<n+2; j++) {
					sticker[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 2; i< n+2; i++) {
				sticker[0][i] = sticker[0][i] + Math.max(sticker[1][i-1], sticker[1][i-2]);
				sticker[1][i] = sticker[1][i] + Math.max(sticker[0][i-1], sticker[0][i-2]);
			}
			System.out.println(Math.max(sticker[0][n+1], sticker[1][n+1]));
		}
	}
	
}
