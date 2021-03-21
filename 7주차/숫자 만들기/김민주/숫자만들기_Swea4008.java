package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.ArrayList;
import java.util.StringTokenizer;

public class 숫자만들기_Swea4008 {
	
	static int N;
	static int [] num;
	static int min, max;
	static int[] operation;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(in.readLine());
			StringTokenizer st = new StringTokenizer(in.readLine());
			operation = new int[4];
			for(int i = 0; i<4; i++) {
				operation[i] = Integer.parseInt(st.nextToken());
			}
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			num = new int[N];
			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < N; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}

			dfs(num[0], 1);
			System.out.println("#" + tc + " " + (max-min));
			 
		}
	}
	
	private static void dfs(int value1, int i) {
		if(i==N) {
			min = Math.min(min, value1);
			max = Math.max(max, value1);
			return;
		}
		
		for(int n = 0; n<4; n++) {
			if(operation[n]!=0) {
				operation[n]--;
				if(n == 0) {
					dfs(value1 + num[i], i+1);
				}
				else if(n == 1) {
					dfs(value1 - num[i], i+1);
				}
				else if(n == 2) {
					dfs(value1 * num[i], i+1);
				}
				else if(n == 3) {
					dfs(value1 / num[i], i+1);
				}
				operation[n]++;
			}
		}
		
	}

}
