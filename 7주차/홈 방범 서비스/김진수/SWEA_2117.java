package com.ssafy.algoStudy_07;

import java.io.*;
import java.util.StringTokenizer;

public class SWEA_2117 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;
		StringTokenizer st;
		int T = Integer.parseInt(reader.readLine());
		int n, m, cur, cnt, l, x, y, d, max;
		boolean fld[][];

		for (int itr = 1; itr <= T; itr++) {
			sb = new StringBuilder();
			max = Integer.MIN_VALUE;

			st = new StringTokenizer(reader.readLine());

			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			fld = new boolean[n][n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(reader.readLine());

				for (int j = 0; j < n; j++)
					if (st.nextToken().charAt(0) == '1')
						fld[i][j] = true;
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					cnt = 0;
					l = 2;

					if (fld[i][j]) {
						cur = m - 1;
						cnt = 1;
					} else {
						cur = -1;
						cnt = 0;
					}
					
					if (0 <= cur && max < cnt)
						max = cnt;

					for (l = 2; l < 2 * n; l++) {
						x = j;
						y = i - l + 1;
						d = 1;
                        
						do {
							if (0 <= y && y < n && 0 <= x && x < n) {
								if (fld[y][x]) {
									cur += (m - 1);
									cnt++;
								} else {
									cur--;
								}
							} else {
                                cur--;
                            }

							switch (d) {
							case 1:
								x++;
								y++;
								if (y == i)
									d = 2;
								break;
							case 2:
								x--;
								y++;
								if (x == j)
									d = 3;
								break;
							case 3:
								x--;
								y--;
								if (y == i)
									d = 4;
								break;
							case 4:
								x++;
								y--;
								if (x == j)
									d = 1;
								break;
							}
						} while (x != j || y != i - l + 1);

						if (0 <= cur && max < cnt)
							max = cnt;
	 				}
				}
			}

			sb.append("#").append(itr).append(" ").append(max);
			System.out.println(sb);
		}
	}
}
