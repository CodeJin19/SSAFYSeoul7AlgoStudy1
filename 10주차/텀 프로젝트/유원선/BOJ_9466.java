package com.ssafy.study;

import java.io.*;
import java.util.*;

public class BOJ_9466 {

	static int n, cnt;
	static int[] stu;
	static boolean[] visited, finished;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			n = Integer.parseInt(br.readLine());
			stu = new int[n + 1];
			visited = new boolean[n + 1];
			finished = new boolean[n + 1];
			
			cnt = 0;
			
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= n; i++) 
				stu[i] = Integer.parseInt(st.nextToken());
			
			for (int i = 1; i <= n; i++) {
				if (!visited[i]) {
					DFS(i);
				}
			}
			
			System.out.println(n - cnt);
		}
	}
	
	static void DFS(int num) {
		visited[num] = true;
		int next = stu[num];
		
		if (!visited[next])
			DFS(next);
		else if (!finished[next]) {
			cnt++; // 자기 자신
			int start = next;
			while (start != stu[next]) {
				cnt++;
				next = stu[next];
			}
		}
		
		finished[num] = true;
	}

}