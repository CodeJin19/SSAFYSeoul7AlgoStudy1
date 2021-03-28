package com.ssafy.study;

import java.io.*;
import java.util.*;

public class BOJ_18429 {
	
	static int n, k, cnt;
	static int[] weight;
	static boolean[] selected;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		weight = new int[n];
		selected = new boolean[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) weight[i] = Integer.parseInt(st.nextToken());
		
		DFS(0, 0);
		System.out.println(cnt);
	}
	
	static void DFS(int level, int w) {
		if (w < 0) return;
		
		if (level == n) {
			cnt++;
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if (!selected[i]) {
				selected[i] = true;
				DFS(level + 1, w + weight[i] - k);
				selected[i] = false;
			}
		}
	}

}
