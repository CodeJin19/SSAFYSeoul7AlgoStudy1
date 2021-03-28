package com.ssafy.study;

import java.io.*;
import java.util.*;

public class BOJ_6087 {

	static int w, h, fromX = -1, fromY, toX, toY;
	static char[][] map;
	static int[][][] visited;
	static PriorityQueue<Info> q = new PriorityQueue<>((i1, i2) -> i1.rotateCnt - i2.rotateCnt);
	
	static class Info {
		int x, y, rotateCnt, dir;
		
		Info (int x, int y, int rotateCnt, int dir) {
			this.x = x;
			this.y = y;
			this.rotateCnt = rotateCnt;
			this.dir = dir;
		}
	}
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());

		map = new char[h][w];
		visited = new int[h][w][4];
		for (int[][] a : visited) {
			for (int[] b : a) {
				Arrays.fill(b, Integer.MAX_VALUE);
			}
		}
		
		for (int i = 0; i < h; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < w; j++) {
				map[i][j] = tmp.charAt(j);
				if (map[i][j] == 'C') {
					if (fromX == -1) {
						fromX = i; fromY = j;
					} else {
						toX = i; toY = j;
					}
				}
			}
		}
		
		System.out.println(BFS(fromX, fromY));
	}
	
	static int BFS(int a, int b) {
		for (int i = 0; i < 4; i++) {
			int nx = a + dx[i];
			int ny = b + dy[i];
			if (!isRange(nx, ny) || map[nx][ny] == '*') continue;
			
			q.add(new Info(nx, ny, 0, i));
		}
		
		while (!q.isEmpty()) {
			Info cur = q.poll();
			int x = cur.x, y = cur.y, cnt = cur.rotateCnt, dir = cur.dir;
			
			if (x == toX && y == toY) 
				return cnt;
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if (!isRange(nx, ny) || map[nx][ny] == '*') continue;
				
				if (dir != i) {
					if (cnt + 1 < visited[nx][ny][i]) {
						q.add(new Info(nx, ny, cnt+1, i));
						visited[nx][ny][i] = cnt + 1;	
					}
				} else {
					if (cnt < visited[nx][ny][i]) {
						q.add(new Info(nx, ny, cnt, i));
						visited[nx][ny][i] = cnt;	
					}
				}
			}
		}
		
		return 0;
	}
	
	static boolean isRange(int nx, int ny) {
		if (nx < 0 || nx >= h || ny < 0 || ny >= w) return false;
		else return true;
	}

}
