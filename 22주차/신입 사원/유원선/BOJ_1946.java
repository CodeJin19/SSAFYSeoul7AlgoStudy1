package com.ssafy.study;

import java.io.*;
import java.util.*;

public class BOJ_1946 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			int[] score = new int[n+1];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int s1 = Integer.parseInt(st.nextToken());
				int s2 = Integer.parseInt(st.nextToken());
				score[s1] = s2;
			}
			
			int min = score[1], cnt = 1;
			for (int i = 2; i <= n; i++) {
				if (score[i] < min) {
					min = score[i];
					cnt++;
				}
			}
			
			System.out.println(cnt);
		}
	}

}
