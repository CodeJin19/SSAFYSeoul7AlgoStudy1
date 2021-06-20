package com.ssafy.study;

import java.io.*;
import java.util.*;

public class BOJ_2056_2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int ans = 0;
		
		Queue<Integer> q = new LinkedList<>();
		
		int[] time = new int[n+1];
		int[] result = new int[n+1];
		int[] inDegree = new int[n+1];
		List<Integer>[] edge = new ArrayList[n+1];
		for (int i = 1; i <= n; i++)
			edge[i] = new ArrayList<>();
		
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			time[i] = t;
			
			int cnt = Integer.parseInt(st.nextToken());
			if (cnt == 0) {
				result[i] = t;
				q.add(i);
			}
			
			inDegree[i] = cnt;
			for (int j = 0; j < cnt; j++) {
				int prev = Integer.parseInt(st.nextToken());
				edge[prev].add(i);
			}
		}
		
		while (!q.isEmpty()) {
			int cur = q.poll();
			
			for (int next : edge[cur]) {
				result[next] = Math.max(result[next], result[cur] + time[next]);
				ans = Math.max(ans, result[next]);
				
				if (--inDegree[next] == 0) {
					q.add(next);
				}
			}
			
			ans = Math.max(ans, result[cur]);
		}
		
		System.out.println(ans);
	}

}
