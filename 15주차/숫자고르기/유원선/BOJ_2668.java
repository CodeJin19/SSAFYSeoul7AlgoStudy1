package com.ssafy.study;

import java.io.*;
import java.util.*;

public class BOJ_2668 {

	static int n;
	static int[] number;
	static boolean[] cycle, finished;
	static List<Integer> list = new ArrayList<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		number = new int[n+1];
		for (int i = 1; i <= n; i++) 
			number[i] = Integer.parseInt(br.readLine());
		
		cycle = new boolean[n+1];
		finished = new boolean[n+1];
		
		for (int i = 1; i <= n; i++) {
			if (!cycle[i]) 
				DFS(i);
		}
		Collections.sort(list);
		
		sb.append(list.size()).append('\n');
		for (int i : list)
			sb.append(i).append('\n');
		System.out.println(sb);
	}
	
	static void DFS(int num) {
		cycle[num] = true;
		int next = number[num];
		
		if (!cycle[next]) {
			DFS(next);
		} else if (!finished[next]) {
			list.add(next);
			int start = number[next];
			for (int i = start; i != next; i = number[i]) 
				list.add(i);
		}
		
		finished[num] = true;
	}

}
