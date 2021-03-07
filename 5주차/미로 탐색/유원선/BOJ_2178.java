package com.ssafy.study;

import java.io.*;
import java.util.*;

public class BOJ_2178 {
	
	static int n, m;
	static char[][] miro;
	static boolean[][] visited;
	static Queue<int[]> q = new LinkedList<>();
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        miro = new char[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++)
        	miro[i] = br.readLine().toCharArray();
        
        System.out.println(BFS());
	}
	
	static int BFS() {
		q.add(new int[] {0,0,1});
		visited[0][0] = true;
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0], y = cur[1], cnt = cur[2];
			
			if (x == n - 1 && y == m - 1)
				return cnt;
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if (nx < 0 || nx >= n || ny < 0 || ny >= m || miro[nx][ny] == '0' || visited[nx][ny]) continue;
				
				q.add(new int[] {nx,ny,cnt+1});
				visited[nx][ny] = true;
			}
		}
		
		return 0;
	}
}
