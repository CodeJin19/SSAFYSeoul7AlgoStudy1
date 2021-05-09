package com.ssafy.study;

import java.io.*;
import java.util.*;

public class BOJ_8972 {

	static int r, c, Ir, Ic;
	static char[][] board, tmp_board;
	static List<Ardu> crazy = new ArrayList<>();
	static List<int[]> explode;
	static String dir;
	static StringBuilder sb;
	
	static class Ardu {
		int idx, x, y;
		boolean isLive;
		
		Ardu (int idx, int x, int y, boolean isLive) {
			this.idx = idx;
			this.x = x;
			this.y = y;
			this.isLive = isLive;
		}
	}
	
	static int[] dr = {0, 1, 1, 1, 0, 0, 0, -1, -1, -1};
	static int[] dc = {0, -1, 0, 1, -1, 0, 1, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		board = new char[r][c];
		
		int id = 0;
		for (int i = 0; i < r; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < c; j++) {
				board[i][j] = tmp.charAt(j);
				if (board[i][j] == 'I') {
					Ir = i; Ic = j;
					board[i][j] = '.';
				}
				if (board[i][j] == 'R') 
					crazy.add(new Ardu(id++,i,j,true));
			}
		}
		dir = br.readLine();
		
		for (int i = 0; i < dir.length(); i++) {
			int d = dir.charAt(i) - '0';
			int nr = Ir + dr[d];
			int nc = Ic + dc[d];
			if (board[nr][nc] != '.') {
				sb.append("kraj ").append(i+1);
				System.out.println(sb);
				return;
			}
			
			Ir = nr; Ic = nc; // 종수 위치 갱신
			
			explode = new ArrayList<>();
			tmp_board = new char[r][c];
			for (char[] row : tmp_board) Arrays.fill(row, '.');
			
			for (Ardu a : crazy) {
				if (a.isLive) {
					int res = move(a.idx, a.x, a.y, i+1);
					if (res == -1) {
						System.out.println(sb);
						return;
					}
				}
			}
			
			for (int[] cur : explode) 
				tmp_board[cur[0]][cur[1]] = '.';		
			
			for (int j = 0; j < r; j++) {
				for (int k = 0; k < c; k++) {
					board[j][k] = tmp_board[j][k];
				}
			}
		}
		
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (board[i][j] != '.')
					board[i][j] = 'R';
			}
		}
		board[Ir][Ic] = 'I';
		
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				sb.append(board[i][j]);
			}
			sb.append('\n');
		}
		
		System.out.println(sb);
	}
	
	static int move(int idx, int x, int y, int time) {
		int min = 10001, rx = 0, ry = 0;
		for (int d = 1; d <= 9; d++) {
			int nx = x + dr[d];
			int ny = y + dc[d];
			
			if (nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
			
			int dist = getDistance(nx, ny, Ir, Ic);
			if (min > dist) {
				min = dist;
				rx = nx; ry = ny;
			}
		}
		
		
		if (tmp_board[rx][ry] != '.') {
			int existed_idx = tmp_board[rx][ry] - '0';
			if (crazy.get(existed_idx).isLive) {
				crazy.get(existed_idx).isLive = false;
				explode.add(new int[] {rx,ry});
			}
			crazy.get(idx).isLive = false;
		} else if (rx == Ir && ry == Ic) {
			sb.append("kraj ").append(time);
			return -1;
		} else {
			tmp_board[rx][ry] = (char) (idx + '0');
			crazy.get(idx).x = rx;
			crazy.get(idx).y = ry;
		}
		
		return 0;
	}
	
	static int getDistance(int r1, int s1, int r2, int s2) {
		return Math.abs(r1 - r2) + Math.abs(s1 - s2);
	}

}
