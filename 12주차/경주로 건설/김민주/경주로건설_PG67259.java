package com.ssafy.programmers;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class 경주로건설_PG67259 {

	static class Node implements Comparable<Node>{
		int x, y, dir, sum;

		public Node(int x, int y, int dir, int sum) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.sum = sum;
		}

		@Override
		public int compareTo(Node o) {
			return this.sum-o.sum;
		}
	}
	
	public static void main(String[] args) {
		int[][] board = {{0,0,0,0,0,0,0,1},{0,0,0,0,0,0,0,0},{0,0,0,0,0,1,0,0},{0,0,0,0,1,0,0,0},{0,0,0,1,0,0,0,1},{0,0,1,0,0,0,1,0},{0,1,0,0,0,1,0,0},{1,0,0,0,0,0,0,0}};
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, -1, 0, 1};
		int N = board.length;
		int answer = Integer.MAX_VALUE;
		boolean [][] visit = new boolean[N][N];
		//PriorityQueue<Node>q = new PriorityQueue<>(); => 우선순위 퀴 사용하려면 3차원배열 사용!
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(0,0,-1,0));
		visit[0][0] = true;
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			int x = node.x;
			int y = node.y;
			int dir = node.dir;
			int s = node.sum;
			
			if(x == N-1 && y == N-1) {
				answer = Math.min(answer, s);
			}
			for(int d = 0; d<4; d++) {
				int di = x + dx[d];
				int dj = y + dy[d];
				if(di < 0 || dj < 0 || di >= N || dj >= N || board[di][dj]==1) continue;
				int newCost;
				if(dir == -1 || dir == d) {
					newCost = s + 100;
				} 
				else newCost = s+ 600;
				
				if(!visit[di][dj] || board[di][dj] >= newCost) {
					visit[di][dj] = true;
					board[di][dj] = newCost;
					q.add(new Node(di, dj, d, newCost));
				}
			}
		}
		System.out.println(answer);
	}
}
