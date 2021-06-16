package com.ssafy.study;

import java.io.*;
import java.util.*;

public class BOJ_5427 {
	
	static int w, h;
	static char[][] map;
	static Queue<int[]> fires, person;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			map = new char[h][w];
			
			fires = new LinkedList<>();
			person = new LinkedList<>();
			
			for (int i = 0; i < h; i++) {
				String tmp = br.readLine();
				for (int j = 0; j < w; j++) {
					map[i][j] = tmp.charAt(j);
					if (map[i][j] == '*') fires.add(new int[] {i,j});
					if (map[i][j] == '@') person.add(new int[] {i,j,1});
				}
			}
			
			while (true) {
				spreadFire();
				int res = movePerson();
				 
				if (res > 0) {
					System.out.println(res);
					break;
				}
				if (res == -1) {
					System.out.println("IMPOSSIBLE");
					break;
				}
			}	
		}

	}
	
	static int movePerson() {
		int size = person.size();
		
		boolean flag = false;
		for (int i = 0; i < size; i++) {
			int[] cur = person.poll();
			int x = cur[0], y = cur[1], cnt = cur[2];
			
			if (x == 0 || x == h-1 || y == 0 || y == w-1) {
				return cnt;
			}
		
			for (int j = 0; j < 4; j++) {
				int nx = x + dx[j];
				int ny = y + dy[j];
				
				if (0 <= nx && nx < h && 0 <= ny && ny < w && map[nx][ny] == '.' && map[ny][ny] != '@') {
					map[nx][ny] = '@';
					person.add(new int[] {nx,ny,cnt+1});
					flag = true;
				}
			}
		}
		
		if (!flag)
			return -1;
		
		return 0;
	}
	
	static void spreadFire() {
		int size = fires.size();
		
		for (int i = 0; i < size; i++) {
			int[] cur = fires.poll();
			int x = cur[0], y =cur[1];
			
			for (int j = 0; j < 4; j++) {
				int nx = x + dx[j];
				int ny = y + dy[j];
				
				if (nx < 0 || nx >= h || ny < 0 || ny >= w || map[nx][ny] == '#' || map[nx][ny] == '*') continue;
				
				map[nx][ny] = '*';
				fires.add(new int[] {nx,ny});
			}
		}
	}

}
