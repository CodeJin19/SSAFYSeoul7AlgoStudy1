package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 물놀이를가자_Swea10966 {

	static int N, M;
	static char [][] map;
	static int [] dx = {1, 0, -1, 0};
	static int [] dy = {0, 1, 0, -1};
	static boolean [][] visited;
	
	static Queue<Water> water;
	
	static class Water{
		int x, y;

		public Water(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int tc = 1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new char[N][M];
			visited = new boolean[N][M];
			water = new LinkedList<Water>();
			for(int i = 0; i<N; i++) {
				String str = in.readLine();
				for(int j = 0; j<M; j++) {
					map[i][j] = str.charAt(j);
					if(map[i][j] == 'W') water.offer(new Water(i, j));
				}
			}
			System.out.println("#" + tc + " " + move());
			
		}
	}
	
	private static int move() {
		int cnt = 0;
		int [][] count = new int[N][M];
		while(!water.isEmpty()) {
			Water w = water.poll();
			int x = w.x;
			int y = w.y;
			for(int d= 0; d<4; d++) {
				int di = x+dx[d];
				int dj = y+dy[d];
				if(di<0 || dj<0 || di>=N || dj >= M || visited[di][dj] || map[di][dj]=='W') continue;
				visited[di][dj] = true;
				count[di][dj] = count[x][y]+1;
				water.offer(new Water(di,dj));
			}
			
		}
		
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				if(map[i][j]=='L')
					cnt+=count[i][j];
			}
		}
		return cnt;
	}
}
