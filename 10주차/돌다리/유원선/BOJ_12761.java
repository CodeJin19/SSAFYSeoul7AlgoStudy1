package com.ssafy.study;

import java.io.*;
import java.util.*;

public class BOJ_12761 {

	static final int MAX = 100000;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		boolean[] visited = new boolean[MAX + 1];
	
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {n,0});
		visited[n] = true;
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int num = cur[0], cnt = cur[1];
			
			if (num == m) {
				System.out.println(cnt);
				break;
			}
			
			for (int i : new int[] {num+1, num-1, num+a, num-a, num+b, num-b, num*a, num*b}) {
				if (i < 0 || i > MAX || visited[i]) continue;
			
				q.add(new int[] {i, cnt+1});
				visited[i] = true;
			}
		}
	}

}
