package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 벽부수고이동하기_BJ2206 {

	static int N, M, ans;
	static int[][] map;
	static int[][] check;
	static int[] dx = {0, 1, 0, -1}; //오른쪽, 아래, 왼쪽, 위쪽-시계방향
	static int[] dy = {1, 0, -1, 0};
	
	static class Wall{
		int x;
		int y;
		int move;
		int cnt;
		
		public Wall(int x, int y, int move, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.move = move; //이동한 횟수
			this.cnt = cnt; //
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int [N][M];
		check = new int [N][M];
		for(int i =0; i<N; i++) {
			String str = in.readLine();
			for(int j = 0; j<M; j++) {
				map[i][j] = str.charAt(j)-'0';
				check[i][j] = Integer.MAX_VALUE;
			}
		}
		
		ans = Integer.MAX_VALUE;
		
		dfs(0,0);
		if(ans == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(ans);
	}	
	
	private static void dfs(int x, int y) {

		Queue<Wall> queue = new LinkedList<>();
		queue.add(new Wall(x, y, 1, 0));
		
		while(!queue.isEmpty()) {
			
			Wall w = queue.poll();
			
			if(w.x == N-1 && w.y == M-1) {
				ans = w.move;
				break;
			}
			
			for(int d = 0; d<4; d++) {
				int di = w.x + dx[d];
				int dj = w.y + dy[d];
				
				if(di < 0 || dj < 0 || di>=N || dj >= M) continue;
				
				if(check[di][dj] <= w.cnt) continue;
				
				if(map[di][dj] == 0) {
					check[di][dj] = w.cnt;
					queue.add(new Wall(di, dj, w.move+1, w.cnt));
				}
				
				else {
					if(w.cnt == 0) {
						check[di][dj] = w.cnt + 1;
						queue.add(new Wall(di, dj, w.move+1, w.cnt+1));
					}
				}
			}
			
		}
	}
}