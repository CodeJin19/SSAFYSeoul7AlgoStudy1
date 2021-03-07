package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토_BJ7576 {

	static int N, M, result;
	static int[][] map;
	static Queue<Tomato> queue;

	static class Tomato {
		int x;
		int y;

		public Tomato(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		queue = new LinkedList<Tomato>();
		int zeroCnt = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0)
					zeroCnt++;
				if (map[i][j] == 1)
					queue.add(new Tomato(i, j));
			}
		}

		/* 저장될 때부터 모든 토마토가 익어있는 상태 */
		if (zeroCnt == 0) {
			System.out.println(0);
		}

		else {
			toma();

			for (int i = 0; i < N; i++) { // 루프 끝났는데 안 익은 토마토가 남아있으면 -1 출력
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 0) {
						System.out.println(-1);
						return;
					}
				}
			}
			System.out.println(result - 1);

		}
	}

	private static void toma() {

		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };

		while (!queue.isEmpty()) {
			Tomato t = queue.poll();

			for (int d = 0; d < 4; d++) { // 사방에 안 익은 토마토 있으면 1로 바꿔주기
				int di = t.x + dx[d];
				int dj = t.y + dy[d];
				if (di < 0 || dj < 0 || di >= N || dj >= M)
					continue;
				if (map[di][dj] == 0 ) {
					queue.add(new Tomato(di, dj));
					map[di][dj] = map[t.x][t.y] + 1;
					result = map[di][dj];
				}
			}
		}

	}
}
