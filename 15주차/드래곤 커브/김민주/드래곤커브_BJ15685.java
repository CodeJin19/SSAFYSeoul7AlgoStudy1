package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 드래곤커브_BJ15685 {
	
	static int N;
	static int [] dx = {1, 0, -1, 0};
	static int [] dy = {0, -1, 0, 1};
	static boolean [][] square;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		square = new boolean[101][101];
		
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			
			square[x][y] = true;
			curve(x, y, d, g);
		}
		System.out.println(check());
	}
	
	public static int check() {
		int cnt = 0;
		for(int i = 0; i<100; i++) {
			for(int j = 0; j<100; j++) {
				if(square[i][j] && square[i][j+1] && square[i+1][j] && square[i+1][j+1]) cnt++;
			}
		}
		return cnt;
	}
	public static void curve(int x, int y, int d, int g) {
		int di = x + dx[d];
		int dj = y + dy[d];
		square[di][dj] = true;
		
		ArrayList<Integer> dragon = new ArrayList<>();
		dragon.add(d);
		
		for(int i = 0; i<g; i++) {
			int size = dragon.size();
			while(--size >= 0) {
				int dir = dragon.get(size);
				dir = (dir+1)%4;
				di += dx[dir];
				dj += dy[dir];
				square[di][dj] = true;
				dragon.add(dir);
			}
		}
	}
}
