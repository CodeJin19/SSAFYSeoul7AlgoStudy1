package com.ssafy.study;

import java.io.*;
import java.util.*;

public class BOJ_14938 {
	
	static final int MAX = 987654321;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int[] area = new int[n+1];
		int[][] dis = new int[n+1][n+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++)
			area[i] = Integer.parseInt(st.nextToken());
        
		for (int[] row : dis) Arrays.fill(row, MAX);
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			dis[s][e] = d; dis[e][s] = d;
		}
        
		//플로이드-와샬
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (dis[i][k] + dis[k][j] < dis[i][j])
						dis[i][j] = dis[i][k] + dis[k][j];
				}
			}
		}
        
        int res = 0;
        for (int i = 1; i <= n; i++) {
        	int tmp = area[i];
        	for (int j = 1; j <= n; j++) {
        		if (dis[i][j] <= m && i != j) tmp += area[j];
        	}
        	res = Math.max(res, tmp);
        }

        System.out.println(res);
	}

}
