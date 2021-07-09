package com.ssafy.study;

import java.io.*;
import java.util.*;

public class BOJ_2573 {
	
	static int n, m;
	static int[][] board;
	static boolean[][] visited;
	
	static Queue<int[]> ices = new LinkedList<>();
	static Queue<int[]> q;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		board = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] > 0) 
					ices.add(new int[] {i,j});
			}
		}
		
		int time = 0;
		while (true) {
			if (checkIsland() >= 2) {
				System.out.println(time);
				break;
			}
			
			breakIce();
			time++;
			
			if (ices.size() == 0) {
				System.out.println(0);
				break;
			}
		}
		
	}
	
	static void breakIce() {
		int[][] tmpBoard = new int[n][m];
		copyBoard(tmpBoard, board);
		
		int size = ices.size();
		for (int i = 0; i < size; i++) {
			int[] cur = ices.poll();
			int x = cur[0], y = cur[1];
			int cnt = 0;
			for (int j = 0; j < 4; j++) {
				int nx = x + dx[j];
				int ny = y + dy[j];
				if (board[nx][ny] == 0)
					cnt++;
			}
			
			tmpBoard[x][y] = Math.max(0, tmpBoard[x][y] - cnt);
			if (tmpBoard[x][y] > 0)
				ices.add(new int[] {x,y});
		}
		
		copyBoard(board, tmpBoard);
	}
	
	static int checkIsland() {
		visited = new boolean[n][m];
		q = new LinkedList<>();
		
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (board[i][j] > 0 && !visited[i][j]) {
					visited[i][j] = true;
					q.add(new int[] {i,j});
					BFS();
					
					cnt++;
				}
			}
		}
		
		return cnt;
	}
	
	static void BFS() {
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				
				if (board[nx][ny] > 0 && !visited[nx][ny]) {
					visited[nx][ny] = true;
					q.add(new int[] {nx,ny});
				}
			}
		}
	}
	
	static void copyBoard(int[][] A, int[][] B) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++)
				A[i][j] = B[i][j];
		}
	}

}
