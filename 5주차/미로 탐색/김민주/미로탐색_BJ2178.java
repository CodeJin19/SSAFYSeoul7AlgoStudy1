package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로탐색_BJ2178 {

	static int N, M;
	static int [][] map;
	static boolean [][]visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			String str = in.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = str.charAt(j)-48;
			}
		}
		miro();
		System.out.println(map[N-1][M-1]);
	}
	
	private static void miro() {
		Queue<int[]> q = new LinkedList<int[]>();
		int dx [] = {-1, 1, 0, 0};
		int dy [] = {0, 0, -1, 1};
		// 처음 출발은 map[0][0]
		q.add(new int[] {0, 0});
		
		while(!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			q.poll();
			//종료지점 map[N-1][M-1]에 도착했으면 종료
			if(x==N-1 && y == M-1) break;
			
			//사방탐색
			for(int d = 0; d<4; d++) {
				int di = x + dx[d];
				int dj = y + dy[d];
				if(di < 0 || dj < 0 || di>=N || dj >= M ) continue;
				else{
					if(map[di][dj] == 1 && !visited[di][dj]) {
						visited[di][dj] = true;
						q.add(new int[] {di,dj});
						map[di][dj] = map[x][y]+1;
					}
				}
			}
			
		}
		
		
	}
}
