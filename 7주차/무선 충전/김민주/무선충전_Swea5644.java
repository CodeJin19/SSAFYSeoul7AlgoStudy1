package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 무선충전_Swea5644 {

	static int M, A, result;
	static int[] moveA;
	static int[] moveB;
	static ArrayList<BC> bc;

	private static class BC {
		int y;
		int x;
		int c;
		int p;

		public BC(int x, int y, int c, int p) {
			super();
			this.x = x;
			this.y = y;
			this.c = c;
			this.p = p;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			moveA = new int[M];
			moveB = new int[M];

			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < M; i++) {
				moveA[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < M; i++) {
				moveB[i] = Integer.parseInt(st.nextToken());
			}

			bc = new ArrayList<BC>();
			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(in.readLine());

				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());

				bc.add(new BC(y-1, x-1, c, p)); //(0,0)~(9,9)로 계산하려고, 행.열 바꿔서

			}

			result = 0;
			move(0, 0, 9, 9);

			System.out.println("#" + tc + " " + result);
		}

	}

	private static void move(int di_a, int dj_a, int di_b, int dj_b) {

//				그대로, 상, 우, 하, 좌 
		int[] dx = { 0, -1, 0, 1, 0 };
		int[] dy = { 0, 0, 1, 0, -1 };
		checkArea(di_a, dj_a, di_b, dj_b);
		for (int i = 0; i < M; i++) {
			int direction_a = moveA[i];
			int direction_b = moveB[i];

			di_a += dx[direction_a];
			dj_a += dy[direction_a];

			di_b += dx[direction_b];
			dj_b += dy[direction_b];

			checkArea(di_a, dj_a, di_b, dj_b);

		}
	}

	// 충전 범위 안에 들어오는지 검사
	private static void checkArea(int di_a, int dj_a, int di_b, int dj_b) {
		int[] sum_a = new int[bc.size()];
		int[] sum_b = new int[bc.size()];
		for (int i = 0; i < A; i++) {
			int x = bc.get(i).x;
			int y = bc.get(i).y;
			int c = bc.get(i).c;
			int p = bc.get(i).p;
			int d_a = Math.abs(x - di_a) + Math.abs(y - dj_a);
			int d_b = Math.abs(x - di_b) + Math.abs(y - dj_b);
			// 충전 범위 안에 들어온다면
			if (d_a <= c)
				sum_a[i] = p;

			// 충전 범위 안에 들어온다면
			if (d_b <= c)
				sum_b[i] = p;

		}

		int max = 0;
		for (int i = 0; i < A; i++) {
			for (int j = 0; j < A; j++) {
				int sum = sum_a[i] + sum_b[j];
				if (sum_a[i] != 0 && sum_b[j] !=0 && i == j)
					sum /= 2;
				max = Math.max(max, sum);
			}
		}
		result += max;

	}
}
