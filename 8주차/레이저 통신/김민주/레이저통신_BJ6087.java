package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 레이저통신_BJ6087 {
	
	static int N, M;
	static char[][] map;
	static ArrayList<int[]> laser;
	static int [][] count;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new char [N][M];
		count = new int[N][M];
		laser = new ArrayList<>();
		
		for(int i = 0; i<N; i++) {
			String str = in.readLine();
			for(int j = 0; j<M; j++) {
				map[i][j] = str.charAt(j);
				count[i][j] = N*M;
				if(map[i][j] == 'C')
					laser.add(new int[] {i,j});
			}
		}
		System.out.println(bfs());
	}
	
	private static int bfs() {
		PriorityQueue<Node>q= new PriorityQueue<>();
		
		int start_x = laser.get(0)[0];
		int start_y = laser.get(0)[1];
		int end_x = laser.get(1)[0];
		int end_y = laser.get(1)[1];
		q.offer(new Node(start_x, start_y, 0, -1));
		count[start_x][start_y] = 0;
		
		int [] dx = {-1, 1, 0, 0};
		int [] dy = {0, 0, -1, 1};
		
		while(!q.isEmpty()) {
			Node head = q.poll();
			if(head.x == end_x && head.y == end_y) return head.cnt;
			
			for(int d = 0; d<4; d++) {
				int di = head.x + dx[d];
				int dj = head.y + dy[d];
				if(di<0 || dj <0 || di >= N || dj >= M || map[di][dj]=='*') continue;
				if(head.dir == d || head.dir == -1){
					if(count[di][dj] >= head.cnt) {
						count[di][dj] = head.cnt;
						q.offer(new Node(di, dj, head.cnt, d));
					}
				}
				else if(head.dir != d) { 
					if(count[di][dj] >= head.cnt+1) {
						count[di][dj] = head.cnt+1;
						q.offer(new Node(di, dj, head.cnt+1, d));
					}
				}
				
			}
			
		}
		
		return -1;
		
	}
	
	static class Node implements Comparable<Node>{
		int x, y, cnt, dir;
		boolean isHor; 
		public Node(int x, int y, int cnt, int dir) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.dir = dir;
		}
		@Override
		public int compareTo(Node o) {
			return this.cnt - o.cnt;
		}
	}
}
