package com.ssafy.study;

import java.io.*;
import java.util.*;

public class BOJ_16987 {
	
	static int n, max;
	static int[][] egg;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		egg = new int[n][2];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			egg[i][0] = Integer.parseInt(st.nextToken());
			egg[i][1] = Integer.parseInt(st.nextToken());
		}
		
		DFS(0);
		System.out.println(max);
	}
	
	static void DFS(int level) {
		if (level == n) {
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				if (egg[i][0] <= 0) cnt++; 
			}

			max = Math.max(max, cnt);
			return;
		}
		
		if (egg[level][0] <= 0) {
			DFS(level+1);
			return;
		}
		
		boolean flag = false;
		for (int i = 0; i < n; i++) {
			if (level != i && egg[i][0] > 0) {
				flag = true;
				
				egg[level][0] -= egg[i][1];
				egg[i][0] -= egg[level][1];
				DFS(level+1);
				egg[level][0] += egg[i][1];
				egg[i][0] += egg[level][1];
			}
		}
		
		if (!flag) {
			DFS(level+1);
			return;
		}
	}

}
