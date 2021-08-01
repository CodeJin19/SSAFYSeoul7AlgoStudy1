package com.ssafy.study;

import java.io.*;
import java.util.*;

public class BOJ_16235 {
	
	static int n, m, k;
	static int[][] board, A;
	static List<Integer>[][] tree;
	
	static int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0};
	static int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		board = new int[n+1][n+1];
		A = new int[n+1][n+1];
		
		tree = new ArrayList[n+1][n+1];
		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= n; j++)
				tree[i][j] = new ArrayList<>();
		
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
				board[i][j] = 5;
			}
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int age = Integer.parseInt(st.nextToken());
			tree[r][c].add(age);
		}
		
		int cnt = 0;
		while (true) {
			springAndSummer();
			fallAndWinter();
			if (++cnt == k) {
				System.out.println(countLiveTree());
				return;
			}
		}
	}
	
	static int countLiveTree() {
		int cnt = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				cnt += tree[i][j].size();
			}
		}
		
		return cnt;
	}
	
	static void springAndSummer() {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (tree[i][j].size() > 0) {
					Collections.sort(tree[i][j]);
					
					Queue<Integer> tmp = new LinkedList<>();
					int extra = 0;
					for (int age : tree[i][j]) {
						if (age > board[i][j]) {
							extra += age / 2;
						} else {
							board[i][j] -= age;
							tmp.add(age+1);
						}
					}
					
					board[i][j] += extra;
					tree[i][j].clear();
					while (!tmp.isEmpty())
						tree[i][j].add(tmp.poll());	
				}
			}
		}
	}
	
	static void fallAndWinter() {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (tree[i][j].size() > 0) {
					for (int age : tree[i][j]) {
						if (age % 5 == 0) {
							for (int d = 0; d < 8; d++) {
								int nr = i + dr[d];
								int nc = j + dc[d];
								if (nr < 1 || nr > n || nc < 1 || nc > n) continue;
								tree[nr][nc].add(1);
							}
						}
					}
				}
			}
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				board[i][j] += A[i][j];
			}
		}
	}

}
