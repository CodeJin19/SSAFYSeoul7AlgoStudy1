package com.ssafy.study;

import java.io.*;
import java.util.*;

public class BOJ_15685 {
	
	static int n;
	static boolean[][] dragon = new boolean[101][101];
	static List<Integer> list;
	
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, -1, 0, 1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			
			list = new ArrayList<>();
			
			// 0세대 처리
			dragon[x][y] = true;
			int nx = x + dx[d];
			int ny = y + dy[d];
			list.add(d);
			dragon[nx][ny] = true;
			curve(nx, ny, g);
		}
		
		int cnt = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (dragon[i][j] && dragon[i][j+1] && dragon[i+1][j] && dragon[i+1][j+1])
					cnt++;
			}
		}
		
		System.out.println(cnt);
	}
	
	static void curve(int x, int y, int g) {
		for (int i = 0; i < g; i++) {
			int size = list.size();
			for (int j = size - 1; j >= 0; j--) {
				int dir = list.get(j);
				dir = (dir + 1) % 4;
				int nx = x + dx[dir], ny = y + dy[dir];
				
				list.add(dir);
				dragon[nx][ny] = true;
				
				x = nx; y = ny;
			}
		}
	}

}
