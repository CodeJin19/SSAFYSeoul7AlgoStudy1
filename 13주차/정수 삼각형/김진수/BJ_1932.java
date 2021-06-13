package com.ssafy.algoStudy_13;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_1932 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int fld[][];
		int n = Integer.parseInt(reader.readLine());
		int max;

		fld = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(reader.readLine());

			for (int j = 0; j <= i; j++) {
				fld[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		if (n == 1) {
			System.out.println(fld[0][0]);
		} else {
			fld[1][0] += fld[0][0];
			fld[1][1] += fld[0][0];

			for (int i = 2; i < n; i++) {
				fld[i][0] += fld[i - 1][0];

				for (int j = 1; j < i; j++) {
					fld[i][j] += Math.max(fld[i - 1][j - 1], fld[i - 1][j]);
				}

				fld[i][i] += fld[i - 1][i - 1];
			}

			max = Integer.MIN_VALUE;

			for (int i = 0; i < n; i++) {
				max = Math.max(max, fld[n - 1][i]);
			}

			System.out.println(max);
		}
	}
}
