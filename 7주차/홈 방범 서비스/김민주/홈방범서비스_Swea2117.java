package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 홈방범서비스_Swea2117 {

	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			max = 1;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					visited = new boolean[N][N];
					Service(i, j);
				}
			}
			System.out.println("#" + tc + " " + max);
		}
	}


	private static void Service(int x, int y) {
//		Queue<Home> q = new LinkedList<>();
		Queue<int[]> q = new LinkedList<>();

		int house = 0;
		int k = 2;
		//그 위치에 집이 있다면 먼저 1로 세팅
		if (map[x][y] == 1)
			house = 1;

//		q.add(new Home(x, y));
		q.add(new int[]{x,y});
		visited[x][y] = true;

		while (!q.isEmpty()) {
			int size = q.size();
			//k는 최대 N+1
			if (k > N + 1)
				break;

			while (size-- > 0) {
//				Home home = q.poll();
				int [] home = q.poll();
				for (int i = 0; i < 4; i++) {
					int di = home[0] + dx[i];
					int dj = home[1] + dy[i];
					if (di < 0 || dj < 0 || di >= N || dj >= N || visited[di][dj])
						continue;
	
					visited[di][dj] = true;
					q.add(new int[] {di,dj});
					if (map[di][dj] == 1) {
						house++;
					}
				}
			}
			//운영비용 구하기
			int cost = k*k+(k-1)*(k-1);
			//보안회사 이익 구하기
			int benefit = M*house-cost;
			//손해를 안봤다면 계산
			if(benefit >= 0) 
				max = Math.max(house, max);
			//k범위 증가시키기
			k++;
		}

	}
//	private static class Home {
//		int x;
//		int y;
//
//		Home(int x, int y) {
//			this.x = x;
//			this.y = y;
//		}
//	}

}
