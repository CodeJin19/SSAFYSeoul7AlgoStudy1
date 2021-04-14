package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 벽돌깨기_Swea5656 {
	static int N, W, H, cnt, min;
	static int [][] map;
	static int [][] copy;
	static int dx[] = {0, 1, 0, -1};
	static int dy[] = {-1, 0, 1, 0};
	
	static class Brick{
		int x, y, num;

		public Brick(int x, int y, int num) {
			super();
			this.x = x;
			this.y = y;
			this.num = num;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int tc = 1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			map = new int [H][W];
			copy = new int [H][W];
			min = Integer.MAX_VALUE;
			for(int i = 0; i<H; i++) {
				st = new StringTokenizer(in.readLine());
				for(int j = 0; j<W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			perm(0, new int[N]);
			System.out.println("#" + tc + " " + min);
			
		}
	}
	
	public static void perm(int toSelect, int [] selected) { //N개의 구슬 발사 지점 (중복순열)
		if(toSelect == N) {
			removeBrick(selected);
			return;
		}
		
		for(int i =0; i<W; i++) {
			selected[toSelect] = i;
			perm(toSelect+1, selected);
		}
		
	}
	
	
	public static void removeBrick(int [] selected) { //벽돌 제거
		Queue<Brick> q = new LinkedList<Brick>();
		copyMap();
		for(int t = 0; t<N; t++) {
			int target = selected[t];
			for(int i = 0; i<H; i++	) {
				if(copy[i][target] != 0) { //제일 위에 있는 벽돌 찾기
					q.offer(new Brick(i, target, copy[i][target]));
					break;
				}
			}
			while(!q.isEmpty()) {
				Brick brick = q.poll();
				int i = brick.x;
				int j = brick.y;
				int num = brick.num;
				copy[i][j] = 0;
				if(num == 1) continue;
				for(int d = 0; d<4; d++) {
					for(int b = 1; b <= num-1; b++) {
						int di = i + dx[d]*b;
						int dj = j + dy[d]*b;
						if(di < 0 || dj < 0 || di >= H || dj >= W || copy[di][dj] == 0) continue;
						if(copy[di][dj] > 1) q.offer(new Brick(di, dj, copy[di][dj]));
						copy[di][dj] = 0;
					}
				}
			}
			arrangeBrick();
		}
		countBrick();
	}
	
	
	public static void arrangeBrick() { //벽돌 정리
		for(int j = 0; j<W; j++) {
			for(int i = H-1; i>0; i--) {
				for(int k = i-1; k >=0; k--) {
					if(copy[i][j] != 0) break;
					if(copy[k][j] != 0) {
						copy[i][j] = copy[k][j];
						copy[k][j] = 0;
						break;
					}
				}
			}
		}
	}
	
	public static void countBrick() { //남아있는 벽돌 세기
		cnt = 0;
		for(int i = 0; i<H; i++) {
			for(int j = 0; j<W; j++) {
				if(copy[i][j]!= 0) {
					cnt++;
				}
			}
		}
		min = Math.min(min, cnt);
	}
	
	public static void copyMap() {
		for(int i = 0; i<H; i++) {
			for(int j = 0; j<W; j++) {
				copy[i][j] = map[i][j];
			}
		}
	}
}

