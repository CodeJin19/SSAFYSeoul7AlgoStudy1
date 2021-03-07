package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 연구소_BJ14502 {

	static int[][] map; // 처음 입력받은 배열
	static int[][] copy_map; //복사해서 사용할 배열
	static int max=0;
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		copy_map = new int[N][M];
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
//		lab(0, 0, new int[N][M]);
		lab(0);
		System.out.println(max);
		
	}
	

	/*private static void lab(int toSelect, int start, int[][] vi) {
		
		if(toSelect == 3) {
			copy();
			for(int i = 0; i<3; i++) {
				int x = vi[i][0];
				int y = vi[i][1];
				copy_map[x][y] = 1;
			}
			virus();
			return;
		}
		
		for(int i = start; i<area.size(); i++) {
			vi[i][0] = area.get(i)[0];
			vi[i][1] = area.get(i)[1];
			lab(toSelect+1, i+1, vi);
		}
	}*/
	
	private static void lab(int cnt) { 
		if(cnt == 3) { //벽 3개 세웠으면
			copy();
			virus();
			return;
		}
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
					lab(cnt+1);
					//벽 세운거 다시 0으로 돌려주기
					map[i][j] = 0;
					
				}
			}
		}
		
	}
	
	private static void virus() { //BFS
		int [] dx = {-1, 1, 0, 0};
		int [] dy = {0, 0, -1, 1};
		//바이러스인거 q에 저장
		Queue<int[]> q = new LinkedList<int[]>();
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				if(copy_map[i][j] == 2)
					q.add(new int[] {i, j});
			}
		}
		//q가 빌 때까지 
		while(!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			q.poll();
			
			for(int d = 0; d<4; d++) {
				int di = x+dx[d];
				int dj = y+dy[d];
				if(di<0 || dj<0 || di>=N || dj>=M) continue;
				if(copy_map[di][dj] == 0) { //빈 곳이면 
					copy_map[di][dj] = 2; //2로 바꾸고
					q.add(new int[] {di, dj}); //q에 저장
				}
			}
		}
		//map을 전체 돌면서 빈곳인 부분 찾기
		int cnt = 0;
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				if(copy_map[i][j] == 0)
					cnt++;
			}
		}
		//최댓값 구하기
		max = Math.max(max, cnt);
		
	}
	//처음 입력 받은 map 복사
	private static void copy() {
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				copy_map[i][j] = map[i][j];
			}
		}
	}
}
