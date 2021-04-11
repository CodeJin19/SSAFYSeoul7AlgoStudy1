package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 돌다리_BJ12761 {
/*
 * +1
 * -1
 * 
 * +A
 * -A
 * 
 * +B
 * -B
 * 
 * *A
 * *B
 */
	static class Node{
		int x, y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
		
	}
	static int A, B, N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
//		Queue<int[]> q = new LinkedList<int[]>();
		Queue<Node> q = new LinkedList<Node>();
		boolean []visited = new boolean[100001];
		q.add(new Node(N, 0));
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			int start = node.x;
			int cnt = node.y;
			
			visited[start] = true;
			if(start == M) {
				System.out.println(cnt);
				break;
			}
			if(start - 1 >= 0 && !visited[start-1]) {
				visited[start-1] = true;
				q.add(new Node(start-1, cnt+1));
			}
			if(start + 1 <= 100000 && !visited[start+1]) {
				visited[start+1] = true;
				q.add(new Node(start+1, cnt+1));
			}
			if(start - A >= 0 && !visited[start - A]) {
				visited[start - A] = true;
				q.add(new Node(start - A, cnt+1));
			}
			if(start + A <= 100000 && !visited[start + A]) {
				visited[start + A] = true;
				q.add(new Node(start + A, cnt+1));
			}
			if(start - B >= 0 && !visited[start - B]) {
				visited[start - B] = true;
				q.add(new Node(start - B, cnt+1));
			}
			if(start + B <= 100000 && !visited[start + B]) {
				visited[start + B] = true;
				q.add(new Node(start + B, cnt+1));
			}
			if(start * A <= 100000 && !visited[start * A]) {
				visited[start * A] = true;
				q.add(new Node(start * A, cnt+1));
			}
			if(start * B <= 100000 && !visited[start * B]) {
				visited[start * B] = true;
				q.add(new Node(start * B, cnt+1));
			}
		}
	}
	
	
}
