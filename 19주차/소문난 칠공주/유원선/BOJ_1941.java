package com.ssafy.study;

import java.io.*;
import java.util.*;

public class BOJ_1941 {

	static final int N = 5, S = 7;
	static int ans;
	
	static char[][] board = new char[N][N];
	static boolean[] visited = new boolean[N*N];
	static int[] selected = new int[S];
	
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < N; j++) {
				board[i][j] = tmp.charAt(j);
			}
		}
		
		DFS(0, 0, 0);
		System.out.println(ans);
	}
	
	static boolean check() {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] tmp_check = new boolean[N][N];
		boolean[][] q_check = new boolean[N][N];
		
		int idx = 0;
		for (int i = 0; i < S; i++) {
			int x = selected[i] / N, y = selected[i] % N;
			tmp_check[x][y] = true;
			if (idx == 0) {
				q_check[x][y] = true;
				idx++;
				q.add(new int[] {x,y});
			}
		}
		
		int cnt = 1;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				
				if (nx < 0 || nx >= N || ny < 0 || ny >= N || !tmp_check[nx][ny] || q_check[nx][ny]) continue;
				
				q_check[nx][ny] = true;
				q.add(new int[] {nx,ny});
				cnt++;
			}
		}
		
		if (cnt == 7) return true;
		else return false;	
	}
	
	static void DFS(int start, int level, int lim) {
		if (lim >= 4) return;
		
		if (level == S) {
			if (check()) ans++;
			return;
		}
		
		for (int i = start; i < N * N; i++) {
			if (visited[i]) continue;
			int x = i / N, y = i % N;
		
			visited[i] = true;
			selected[level] = i;
			if (board[x][y] == 'Y') DFS(i+1, level+1, lim+1);
			else DFS(i+1, level+1, lim);
			visited[i] = false;
		}
	}

}
