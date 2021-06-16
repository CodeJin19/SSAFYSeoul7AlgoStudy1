package com.ssafy.study;

import java.io.*;
import java.util.*;

public class BOJ_13305 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		long[] dis = new long[n-1];
		long[] cost = new long[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n-1; i++) dis[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) cost[i] = Integer.parseInt(st.nextToken());
		
		long ans = dis[0] * cost[0];
		int prev = 0;
		for (int i = 1; i < n-1; i++) {
			if (cost[i] < cost[prev]) {
				ans += dis[i] * cost[i];
				prev = i;
			}
			else ans += dis[i] * cost[prev];
		}
		
		System.out.println(ans);
	}

}
