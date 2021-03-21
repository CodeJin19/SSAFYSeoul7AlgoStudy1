package com.ssafy.study;

import java.io.*;
import java.util.*;

public class SWEA_5656 {

	static int n, w, h, res;
	static int[][] board;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
	
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			board = new int[h][w];
			res = Integer.MAX_VALUE;
			
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) 
					board[i][j] = Integer.parseInt(st.nextToken());
			}
			
			DFS(0);
			System.out.println("#" + t + " " + res);
		}
	}
	
	static void DFS(int idx) {
		if (idx == n) {
			res = Math.min(res, getCnt());
			return;
		}
		
		int[][] copy_board = new int[h][w];
		boolean flag = false;
		
		for (int i = 0; i < w; i++) {
			copyArray(copy_board, board);
			for (int j = 0; j < h; j++) {
				if (board[j][i] > 0) {
					flag = true;
					
					breakBricks(j, i, board[j][i]);
					downBricks();
					DFS(idx + 1);
					
					break;
				}
			}
			copyArray(board, copy_board);
		}
		
		if (!flag) {
			res = 0;
			return;
		}
		
	}
	
	static void breakBricks(int x, int y, int num) {
		board[x][y] = 0;
		
		for (int i = 0; i < 4; i++) {
			for (int j = 1; j < num; j++) {
				int nx = x + dx[i] * j;
				int ny = y + dy[i] * j;
				
				if (nx < 0 || nx >= h || ny < 0 || ny >= w || board[nx][ny] == 0) continue;
				
				if (board[nx][ny] == 1) board[nx][ny] = 0;
				else breakBricks(nx, ny, board[nx][ny]);
			}
		}
	}
	
	static void downBricks() {
		for (int i = 0; i < w; i++) {
			for (int j = h - 2; j >= 0; j--) {
				if (board[j][i] > 0 && board[j + 1][i] == 0) {
					int k = j + 1;
					
					while (true) {
						if (k >= h || board[k][i] > 0) {
							board[k - 1][i] = board[j][i];
							board[j][i] = 0;
							break;
						}
						k++;
					}	
				}
			}
		}
	}
	
	static int getCnt() {
		int cnt = 0;
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (board[i][j] > 0) cnt++;
			}
		}
		
		return cnt;
	}
	
	static void copyArray(int[][] A, int[][] B) {
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				A[i][j] = B[i][j];
			}
		}
	}

}
