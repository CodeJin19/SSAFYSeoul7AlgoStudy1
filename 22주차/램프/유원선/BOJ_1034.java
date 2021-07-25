package com.ssafy.study;

import java.io.*;
import java.util.*;

public class BOJ_1034 {

	static int n, m, k, max;
	static char[][] lamp;
	static boolean[] check;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		lamp = new char[n][m];
		check = new boolean[n];
		for (int i = 0; i < n; i++) {
			lamp[i] = br.readLine().toCharArray();
		}
		k = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			if (check[i]) continue;
			check[i] = true;
			
			int cnt = 0;
			for (int j = 0; j < m; j++) {
				if (lamp[i][j] == '0') cnt++;
			}
			
			if (cnt <= k && cnt % 2 == k % 2) {
				max = Math.max(countLamp(i), max);
			}
		}
		
		System.out.println(max);
	}
	
	static int countLamp(int cur) {
		int cnt = 1;
		boolean flag;
		for (int i = cur+1; i < n; i++) {
			flag = true;
			for (int j = 0; j < m; j++) {
				if (lamp[cur][j] != lamp[i][j]) {
					flag = false;
					break;
				}
			}
			
			if (flag) {
				check[i] = true;
				cnt++;
			}
		}
		
		return cnt;
	}
	
}