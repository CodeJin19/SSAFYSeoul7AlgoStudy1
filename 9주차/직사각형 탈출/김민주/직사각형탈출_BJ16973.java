package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 직사각형탈출_BJ16973 {

	static int N, M, H, W, Sr, Sc, Fr, Fc;
	static int [][] map;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	
	static class Node {
		int x, y, cnt;

		public Node(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int [N][M];
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(in.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		Sr = Integer.parseInt(st.nextToken())-1;
		Sc = Integer.parseInt(st.nextToken())-1;
		Fr = Integer.parseInt(st.nextToken())-1;
		Fc = Integer.parseInt(st.nextToken())-1;
		System.out.println(bfs());
	}
	
	private static int bfs() {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(Sr, Sc, 0));
		boolean visited[][] = new boolean[N][M];
		visited[Sr][Sc] = true;
		
		while(!q.isEmpty()) {
			Node head = q.poll();
			if(head.x == Fr && head.y == Fc) 
				return head.cnt;
			
			for(int d = 0; d<4; d++) {
				int di = head.x + dx[d];
				int dj = head.y + dy[d];
				if(di<0 || dj<0 || di>= N || dj >= M || visited[di][dj]) continue;
				if(!checkArea(di, dj)) continue;
				visited[di][dj] = true;
				q.offer(new Node(di, dj, head.cnt+1)); 
			}
		}
		
		return -1;
	}
	
	private static boolean checkArea(int di, int dj) {
		if(di<0 || dj < 0 || di + H >= N || dj + W >= M) return false; // 이건 왜 안될까..
	
		for(int i = di; i<di+H; i++) {
			for(int j = dj; j<dj+W; j++) {
				if(map[i][j] == 1) {
					return false;
				}
			}
		}
//		i<0 || j < 0 || i >= N || j >= M || 
		return true;
	}
}
