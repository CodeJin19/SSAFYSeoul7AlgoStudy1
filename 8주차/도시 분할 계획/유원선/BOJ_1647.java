package com.ssafy.study;

import java.io.*;
import java.util.*;

public class BOJ_1647 {
	
	static int n, m, town;
	static int[] parents;
	static List<Info> list = new ArrayList<>();
	
	static class Info {
		int a, b, c;
		
		Info(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		town = n;
		parents = new int[n + 1];
		for (int i = 1; i <= n; i++) parents[i] = i;
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list.add(new Info(a, b, c));
		}
		
		Collections.sort(list, (i1, i2) -> i1.c - i2.c);
		
		long sum = 0;
		for (Info cur : list) {
			if (isSameParents(cur.a, cur.b)) continue;
			
			union(cur.a, cur.b);
			sum += cur.c;
			
			if (town <= 2)
				break;
		}

		System.out.println(sum);
	}
	
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if (a == b) return;
		
		if (a < b) parents[b] = a;
		else parents[a] = b;
		
		town--;
	}
	
	static int find(int a) {
		if (a == parents[a]) return a;
		else return parents[a] = find(parents[a]);
	}
	
	static boolean isSameParents(int a, int b) {
		return find(a) == find(b);
	}

}
