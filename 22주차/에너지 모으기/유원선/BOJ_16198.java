package com.ssafy.study;

import java.io.*;
import java.util.*;

public class BOJ_16198 {

	static int n;
	static long max;
	static List<Integer> list = new ArrayList<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		DFS(0);
		System.out.println(max);
	}
	
	static void DFS(long sum) {
		if (list.size() == 2) {
			max = Math.max(max, sum);
			return;
		}
		
		for (int i = 1; i < list.size()-1; i++) {
			int removed = list.get(i);
			int weight = list.get(i-1) * list.get(i+1);
			
			list.remove(i);
			DFS(sum + weight);
			list.add(i, removed);
		}
	}

}
