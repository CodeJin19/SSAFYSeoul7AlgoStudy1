package com.ssafy.algoStudy_07;

import java.io.*;
import java.util.*;

public class SWEA_10966 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;
		StringTokenizer st;
		int T = Integer.parseInt(reader.readLine());
		String str;
		Queue<int[]> queue;
		int d[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
		int cnt[][];
		int n, m, x, y, nx, ny, sum;
		char fld[][];

		for (int test_case = 1; test_case <= T; test_case++) {
			sb = new StringBuilder();

			queue = new LinkedList<int[]>();
			sum = 0;

			st = new StringTokenizer(reader.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			fld = new char[n][m];
			cnt = new int[n][m];

			for (int i = 0; i < n; i++) {
				str = reader.readLine();

				for (int j = 0; j < m; j++) {
					fld[i][j] = str.charAt(j);

					if (fld[i][j] == 'W') {
						cnt[i][j] = 0;
						queue.offer(new int[] { i, j});
					} else {
						cnt[i][j] = -1;
					}
				}
			}

			while (!queue.isEmpty()) {
				y = queue.peek()[0];
				x = queue.peek()[1];
				queue.poll();

				for (int i = 0; i < 4; i++) {
					ny = y + d[i][0];
					nx = x + d[i][1];

					if (0 <= ny && ny < n && 0 <= nx && nx < m && cnt[ny][nx] == -1) {
						cnt[ny][nx] = cnt[y][x] + 1;
						sum += cnt[ny][nx];
						queue.offer(new int[] { ny, nx });
					}
				}
			}

			sb.append("#").append(test_case).append(" ").append(sum);
			System.out.println(sb);
		}
	}
}
