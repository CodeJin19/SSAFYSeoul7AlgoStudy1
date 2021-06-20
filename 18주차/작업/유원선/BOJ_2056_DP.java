package com.ssafy.study;

import java.io.*;
import java.util.*;

public class BOJ_2056 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[] time = new int[n+1];
		int res = 0;
		
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			
			if (num == 0) time[i] = t;
			
			int max = 0;
			for (int j = 0; j < num; j++) {
				int prev = Integer.parseInt(st.nextToken());
				max = Math.max(max, time[prev]);
			}
			
			time[i] = max + t;
			res = Math.max(res, time[i]);
		}
		
		System.out.println(res);
	}

}
