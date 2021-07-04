package com.ssafy.study;

import java.io.*;
import java.util.*;

public class BOJ_2665_2 {
	
	static int n;
	static char[][] board;
	static int[][] visited;
	
	static Queue<int[]> q = new LinkedList<>();
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		board = new char[n][n];
		visited = new int[n][n];
		for (int i = 0; i < n; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < n; j++)
				board[i][j] = tmp.charAt(j);
		}
		
		for (int[] row : visited) Arrays.fill(row, Integer.MAX_VALUE);
		
		BFS();
		
		System.out.println(visited[n-1][n-1]);
	}
	
	static void BFS() {
		q.add(new int[] {0,0});
		visited[0][0] = 0;
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0], y = cur[1];

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
				
				if (board[nx][ny] == '1' && visited[nx][ny] > visited[x][y]) {
					q.add(new int[] {nx,ny});
					visited[nx][ny] = visited[x][y];
				}
				if (board[nx][ny] == '0' && visited[nx][ny] > visited[x][y] + 1) {
					q.add(new int[] {nx,ny});
					visited[nx][ny] = visited[x][y] + 1;
				}
			}
		}
	}

}
