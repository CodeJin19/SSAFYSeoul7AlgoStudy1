package com.ssafy.study;

import java.io.*;
import java.util.*;

public class BOJ_1389 {
	
	static final int MAX = 987654321;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] dis = new int[n+1][n+1];
		for (int[] row : dis) 
			Arrays.fill(row, MAX);
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			dis[a][b] = 1;
			dis[b][a] = 1;
		}
		
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (dis[i][k] + dis[k][j] < dis[i][j])
						dis[i][j] = dis[i][k] + dis[k][j];
				}
			}
		}
		
		int min = Integer.MAX_VALUE, idx = 0;
		for (int i = 1; i <= n; i++) {
			int sum = 0;
			for (int j = 1; j <= n; j++) {
				if (i != j) 
					sum += dis[i][j];
			}
			
			if (sum < min) {
				min = sum;
				idx = i;
			}
		}
		
		System.out.println(idx);
	}

}
