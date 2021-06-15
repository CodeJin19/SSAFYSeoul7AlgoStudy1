package com.ssafy.baekjoon;

import java.io.*;
import java.util.*;

public class 불_BJ5427 {

	static class Node{
		int x, y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	
	}
	static int h, w;
	static char map[][];
	static boolean [][] visited;
	static Queue<int[]> q;
	static Queue<int[]> fire;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			map = new char[h][w];
			q = new LinkedList<>();
			fire = new LinkedList<>();
			visited = new boolean[h][w];
			for(int i = 0; i<h; i++) {
				String str = in.readLine();
				for(int j = 0; j<w; j++) {
					map[i][j] = str.charAt(j);
					if(map[i][j] == '@') q.offer(new int[]{i,j});
					else if(map[i][j] == '*') fire.offer(new int[]{i,j});
				}
			}
			int result = move();
			if(result==-1) sb.append("IMPOSSIBLE").append("\n");
			else sb.append(++result).append("\n");	
			
		}
		System.out.println(sb.toString());
	}
	
	
	private static int move() {
		int [] dx = {-1, 1, 0, 0};
		int [] dy = {0, 0, -1, 1};
		int time=0;
		while(!q.isEmpty()) {
			//1. 불이 동서남북 방향으로 퍼짐(벽에는 안붙음)
			int size = fire.size();
			while(size-->0) {
				int[] f = fire.poll();
				int x = f[0];
				int y = f[1];
				for(int d = 0; d<4; d++) {
					int di = x+dx[d];
					int dj = y+dy[d];
					if(di<0 || dj<0 || di>=h || dj>=w || map[di][dj]=='#' || map[di][dj]=='*') continue;
					else {
						map[di][dj] = '*';
						fire.add(new int[]{di,dj});
					}
				}
			}
			
			//2. 상근 이동
			size = q.size();
			while(size-->0) {
				int[] node = q.poll();
				int sx = node[0];
				int sy = node[1];
				
				//경계선에 있으면 탈출 성공
				if(sx == 0 || sy == 0 || sx == h-1 || sy == w-1) {
					return time;
					
				}
						
				for(int d = 0; d<4; d++) {
					int di = sx + dx[d];
					int dj = sy + dy[d];
					if(di<0 || dj<0 || di>=h || dj>=w) continue;
					if(map[di][dj]!='*' && !visited[di][dj] && map[di][dj]!='#') { //불도 없고 간 적도 없고 벽도 아니면
						visited[di][dj] = true;
						q.offer(new int[]{di,dj});
					}
				}
			}
			time++;
		}
		return -1;
	}
	
}
