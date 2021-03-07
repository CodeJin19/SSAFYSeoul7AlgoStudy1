package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 행복유치원_BJ13164 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int [] child = new int [N];
		
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i<N; i++) {
			child[i] = Integer.parseInt(st.nextToken());
		}
		
		int [] tall = new int[N];
		for(int i = 1; i<N; i++) {
			tall[i] = child[i]-child[i-1];
		}
		
		Arrays.sort(tall);
		
		int cost = 0;
		for(int i = 1; i<=N-K; i++) {
			cost += tall[i];
		}
			
		System.out.println(cost);
		
	}
}
