package com.ssafy.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Alphabet_BJ1987 {
	
		static int[] dx = { -1, 1, 0, 0 };
		static int[] dy = { 0, 0, -1, 1 };
		
		static int R, C, cnt, max;
		static char board[][];
		static boolean alp[];
		
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new char[R][C];
		alp = new boolean[26];
		max = 0;
		for (int i = 0; i < R; i++) {
			String str = in.readLine();
			for (int j = 0; j < C; j++) {
				board[i][j] = str.charAt(j);
			}
		}
		move(0,0,1);
		System.out.println(max);

	}
	
	private static void move(int i, int j, int cnt) {
		alp[board[i][j] - 'A'] = true;
		for (int d = 0; d < 4; d++) {
			int di = i + dx[d];
			int dj = j + dy[d];
			if (di >= 0 && dj >= 0 && di <= R - 1 && dj <= C - 1) {
				int b = board[di][dj] - 'A';
				if (!alp[b]) {
					move(di, dj, cnt+1); // 움직인 횟수 cnt+1
				}
			}
		}
		alp[board[i][j] - 'A'] = false; //다시 초기화
		max = Math.max(max, cnt); //최댓값 찾기
	}
}
