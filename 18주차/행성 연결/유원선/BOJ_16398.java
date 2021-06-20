package com.ssafy.study;

import java.io.*;
import java.util.*;

public class BOJ_16398 {
	
	static int n;
	static int[] parents;
	static class Node implements Comparable<Node> {
		int x, y, cost;
		
		Node (int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		parents = new int[n+1];
		for (int i = 1; i <= n; i++) parents[i] = i;
		
		List<Node> list = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				int c = Integer.parseInt(st.nextToken());
				if (i < j) {
					list.add(new Node(i, j, c));
				}
			}
		}
		
		Collections.sort(list);
		
		long sum = 0;
		for (Node n : list) {
			if (!isSameParents(n.x, n.y)) {
				union(n.x, n.y);
				sum += n.cost;
			}
		}
		
		System.out.println(sum);
	}
	
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if (a == b) return;
		if (a < b) parents[a] = b;
		else parents[b] = a;
	}
	
	static int find(int a) {
		if (a == parents[a]) return a;
		else return parents[a] = find(parents[a]);
	}
	
	static boolean isSameParents(int a, int b) {
		return find(a) == find(b);
	}

}
