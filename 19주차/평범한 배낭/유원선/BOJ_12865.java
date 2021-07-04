package com.ssafy.study;

import java.io.*;
import java.util.*;

public class BOJ_12865 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[][] product = new int[n+1][2];
		int[][] bag = new int[n+1][k+1];
		
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			product[i][0] = Integer.parseInt(st.nextToken());
			product[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= k; j++) {
				int val = 0;
				if (j - product[i][0] >= 0)
					val = product[i][1] + bag[i-1][j-product[i][0]];
				bag[i][j] = Math.max(val, Math.max(bag[i][j-1], bag[i-1][j]));
			}
		}
		
		System.out.println(bag[n][k]);
	}

}
