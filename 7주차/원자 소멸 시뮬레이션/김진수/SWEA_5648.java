package com.ssafy.algoStudy_07;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_5648 {
	static class atom {
		int y;
		int x;
		int d;
		int k;

		public atom(int y, int x, int d, int k) {
			super();
			this.y = y;
			this.x = x;
			this.d = d;
			this.k = k;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;
		ArrayList<int[]> list, nextList;
		int T = Integer.parseInt(reader.readLine());
		atom fld[][][];
		int tmp[];
		int n, x, y, d, k, l, idx, sum;
		boolean isExploded;

		for (int test_case = 1; test_case <= T; test_case++) {
			sb = new StringBuilder();
			list = new ArrayList<int[]>();
			fld = new atom[2001][2001][4];
			sum = 0;

			n = Integer.parseInt(reader.readLine());

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(reader.readLine());

				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				d = Integer.parseInt(st.nextToken());
				k = Integer.parseInt(st.nextToken());

				list.add(new int[] { y, x, d, k });
				atom newAtom = new atom(y, x, d, k);
				fld[y + 1000][x + 1000][0] = newAtom;
			}

			while (true) {
				l = list.size();
				nextList = new ArrayList<int[]>();

				for (int i = 0; i < l; i++) {
					tmp = list.get(i);
					y = tmp[0];
					x = tmp[1];
					d = tmp[2];
					k = tmp[3];

					switch (d) {
					case 0:
						if (1000 < y + 1)
							break;

						nextList.add(new int[] { y + 1, x, d, k });

						idx = 0;
						while (fld[y + 1 + 1000][x + 1000][idx] != null)
							idx++;

						fld[y + 1 + 1000][x + 1000][idx] = fld[y + 1000][x + 1000][0];
						fld[y + 1000][x + 1000][0] = null;
						break;
					case 1:
						if (y - 1 < -1000)
							break;

						nextList.add(new int[] { y - 1, x, d, k });

						idx = 0;
						while (fld[y - 1 + 1000][x + 1000][idx] != null)
							idx++;

						fld[y - 1 + 1000][x + 1000][idx] = fld[y + 1000][x + 1000][0];
						fld[y + 1000][x + 1000][0] = null;
						break;
					case 2:
						if (x - 1 < -1000)
							break;

						nextList.add(new int[] { y, x - 1, d, k });

						idx = 0;
						while (fld[y + 1000][x - 1 + 1000][idx] != null)
							idx++;

						fld[y + 1000][x - 1 + 1000][idx] = fld[y + 1000][x + 1000][0];
						fld[y + 1000][x + 1000][0] = null;
						break;
					case 3:
						if (1000 < x + 1)
							break;

						nextList.add(new int[] { y, x + 1, d, k });

						idx = 0;
						while (fld[y + 1000][x + 1 + 1000][idx] != null)
							idx++;

						fld[y + 1000][x + 1 + 1000][idx] = fld[y + 1000][x + 1000][0];
						fld[y + 1000][x + 1000][0] = null;
						break;
					}
				}

				list = nextList;
				nextList = new ArrayList<int[]>();

				for (int i = 0; i < l; i++) {
					tmp = list.get(i);
					y = tmp[0];
					x = tmp[1];
					d = tmp[2];
					k = tmp[3];

					switch (d) {
					case 0:
						if (fld[y - 1][x][0] != null) {
							idx = 0;
							isExploded = false;
							
							while (fld[y - 1][x][idx] != null) {
								if (fld[y - 1][x][idx].d == 1) {
									isExploded = true;
									break;
								}
								idx++;
							}
							
							if(isExploded) {
								
							} else {
								
							}
						}
						if (1000 < y + 1)
							break;

						nextList.add(new int[] { y + 1, x, d, k });

						idx = 0;
						while (fld[y + 1 + 1000][x + 1000][idx] != null)
							idx++;

						fld[y + 1 + 1000][x + 1000][idx] = fld[y + 1000][x + 1000][0];
						fld[y + 1000][x + 1000][0] = null;
						break;
					case 1:
						if (y - 1 < -1000)
							break;

						nextList.add(new int[] { y - 1, x, d, k });

						idx = 0;
						while (fld[y - 1 + 1000][x + 1000][idx] != null)
							idx++;

						fld[y - 1 + 1000][x + 1000][idx] = fld[y + 1000][x + 1000][0];
						fld[y + 1000][x + 1000][0] = null;
						break;
					case 2:
						if (x - 1 < -1000)
							break;

						nextList.add(new int[] { y, x - 1, d, k });

						idx = 0;
						while (fld[y + 1000][x - 1 + 1000][idx] != null)
							idx++;

						fld[y + 1000][x - 1 + 1000][idx] = fld[y + 1000][x + 1000][0];
						fld[y + 1000][x + 1000][0] = null;
						break;
					case 3:
						if (1000 < x + 1)
							break;

						nextList.add(new int[] { y, x + 1, d, k });

						idx = 0;
						while (fld[y + 1000][x + 1 + 1000][idx] != null)
							idx++;

						fld[y + 1000][x + 1 + 1000][idx] = fld[y + 1000][x + 1000][0];
						fld[y + 1000][x + 1000][0] = null;
						break;
					}
				}

				break;
			}

			sb.append("#").append(test_case).append(" ").append(sum);
			System.out.println(sb);
		}
	}
}
