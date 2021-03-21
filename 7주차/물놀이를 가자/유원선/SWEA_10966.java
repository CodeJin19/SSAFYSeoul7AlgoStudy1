package com.ssafy.study;

import java.io.*;
import java.util.*;

public class SWEA_10966 {
	
	static int n, m, sum;
	static char[][] map;
	static int[][] dis;
	
	static Queue<int[]> q;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
	
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			sum = 0;
			
			q = new LinkedList<>();
			dis = new int[n][m];
			map = new char[n][m];
		
			for (int[] row : dis) Arrays.fill(row, -1);
			
			for (int i = 0; i < n; i++) {
				String tmp = br.readLine();
				for (int j = 0; j < m; j++) {
					map[i][j] = tmp.charAt(j);
					if (map[i][j] == 'W') {
						q.add(new int[] {i,j});
						dis[i][j] = 0;
					}
				}
			}
			
			BFS();
			System.out.println("#" + t + " " + sum);
		}
	}
	
	static void BFS() {
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0], y = cur[1];
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if (nx < 0 || nx >= n || ny < 0 || ny >= m || dis[nx][ny] != -1) continue;
				
				dis[nx][ny] = dis[x][y] + 1;	
				q.add(new int[] {nx,ny});
				sum += dis[nx][ny];
			}
		}
	}
}
