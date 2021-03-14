package com.ssafy.study;

import java.io.*;
import java.util.*;

public class BOJ_17836 {
	
	static int n, m, t;
	static int[][] map;
	static boolean[][][] visited;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	static class Soldier {
		int x, y, cnt, sword;
		
		Soldier(int x, int y, int cnt, int sword) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.sword = sword;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m][2];
        
        for (int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j = 0; j < m; j++) 
        		map[i][j] = Integer.parseInt(st.nextToken());
        }
        
        int res = BFS();
        
        if (res != 0) System.out.println(res);
        else System.out.println("Fail");
	}
	
	static int BFS() {
		Queue<Soldier> q = new LinkedList<>();
		q.add(new Soldier(0, 0, 0, 0));
		visited[0][0][0] = true;
		
		while (!q.isEmpty()) {
			Soldier cur = q.poll();
			int x = cur.x, y = cur.y, cnt = cur.cnt, sword = cur.sword;
			
			if (cnt > t) return 0;
			if (x == n - 1 && y == m - 1) return cnt;
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				sword = cur.sword;
				
				if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny][sword]) continue;
				if (sword == 0 && map[nx][ny] != 1) {
					if (map[nx][ny] == 2) 
						sword = 1;
					
					q.add(new Soldier(nx, ny, cnt + 1, sword));
					visited[nx][ny][sword] = true;
				}
				else if (sword == 1) {
					q.add(new Soldier(nx, ny, cnt + 1, sword));
					visited[nx][ny][sword] = true;
				}
			}
		}
		
		return 0;
	}
}
