package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 숨바꼭질3_BJ13549 {

	static class Node{
		int x, cnt;

		public Node(int x, int cnt) {
			super();
			this.x = x;
			this.cnt = cnt;
		}
		
	}
	static int N, K, min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		bfs();
		System.out.println(min);
	}
	
	private static void bfs() {
		boolean[]visit = new boolean[100001];
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(N, 0));
		visit[N] = true;
		while(!q.isEmpty()) {
			Node node = q.poll();
			int n = node.x;
			int c = node.cnt;
			
			if(n == K) {
				min = Math.min(min, c);
				return;
			}
			if(2*n <= 100000 && !visit[2*n]) {
				visit[2*n] = true;
				q.add(new Node(2*n, c));
			}
			
			if(n-1>=0 && !visit[n-1]) {
				visit[n-1] = true;
				q.add(new Node(n-1, c+1));
			}
			
			if(n+1<=100000&& !visit[n+1]) {
				visit[n+1] = true;
				q.add(new Node(n+1, c+1));
			}
		}
	}
}
