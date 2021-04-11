package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 슈퍼스타k_BJ2865 {
	
	static class Node{
		int x;
		double y;

		public Node(int x, double y) {
			super();
			this.x = x;
			this.y = y;
		}

		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		boolean [] check = new boolean[N+1];
		PriorityQueue<Node> pq = new PriorityQueue<>((x,y)->Double.compare(y.y, x.y));
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j<N; j++) {
				int num = Integer.parseInt(st.nextToken());
				double doub = Double.parseDouble(st.nextToken());
				pq.add(new Node(num, doub));
			}
		}
		
		double sum = 0;
		int cnt = 0;
		while(true) {
			if(cnt == K) break;
			Node node = pq.poll();
			if(!check[node.x]) {
				sum += node.y;
				check[node.x] = true;
				cnt++;
			}
		}
		
		System.out.printf("%.1f", sum);
	}
}
