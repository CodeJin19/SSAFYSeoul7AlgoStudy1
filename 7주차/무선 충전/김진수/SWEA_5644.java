package com.ssafy.algoStudy_07;

import java.io.*;
import java.util.StringTokenizer;

public class SWEA_5644 {
	public static int getMax(int ay, int ax, int by, int bx, int fld[][], int power[]) {
		int aMax, aMaxIdx, aMin;
		int bMax, bMaxIdx, bMin;
		boolean a[] = new boolean[power.length];
		boolean b[] = new boolean[power.length];

		for (int i = 1; i < power.length; i++)
			if ((fld[ay][ax] & (1 << (i - 1))) == 1 << (i - 1))
				a[i] = true;

		for (int i = 1; i < power.length; i++)
			if ((fld[by][bx] & (1 << (i - 1))) == 1 << (i - 1))
				b[i] = true;

		aMax = 0;
		aMaxIdx = 0;
		aMin = 0;
		bMax = 0;
		bMaxIdx = 0;
		bMin = 0;

		for (int i = 1; i < power.length; i++) {
			if (a[i] && aMax < power[i]) {
				aMax = power[i];
				aMaxIdx = i;
			}
				
			if (b[i] && bMax < power[i]) {
				bMax = power[i];
				bMaxIdx = i;
			}
		}

		for (int i = 1; i < power.length; i++) {
			if (a[i] && power[i] != aMax && aMin < power[i])
				aMin = power[i];
			
			if (b[i] && power[i] != bMax && bMin < power[i])
				bMin = power[i];
		}
			
		if (aMaxIdx == bMaxIdx)
			if (aMin < bMin)
				return aMax + bMin;
			else
				return aMin + bMax;
		else
			return aMax + bMax;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;
		StringTokenizer st;
		int T = Integer.parseInt(reader.readLine());
		int m, bc, ax, ay, bx, by, x, y, l, sum;
		int a[], b[], power[];
		int d[][] = { { 0, 0 }, { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
		int fld[][];

		for (int itr = 1; itr <= T; itr++) {
			sb = new StringBuilder();
			fld = new int[11][11];
			ax = 1;
			ay = 1;
			bx = 10;
			by = 10;

			st = new StringTokenizer(reader.readLine());
			m = Integer.parseInt(st.nextToken());
			bc = Integer.parseInt(st.nextToken());

			a = new int[m];
			b = new int[m];
			power = new int[bc + 1];

			st = new StringTokenizer(reader.readLine());
			for (int i = 0; i < m; i++)
				a[i] = st.nextToken().charAt(0) - '0';

			st = new StringTokenizer(reader.readLine());
			for (int i = 0; i < m; i++)
				b[i] = st.nextToken().charAt(0) - '0';

			for (int k = 1; k <= bc; k++) {
				st = new StringTokenizer(reader.readLine());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				l = Integer.parseInt(st.nextToken());
				power[k] = Integer.parseInt(st.nextToken());

				for (int i = 1; i < 11; i++)
					for (int j = 1; j < 11; j++)
						if (Math.abs(y - i) + Math.abs(x - j) <= l)
							fld[i][j] |= (1 << (k - 1));
			}

			// 처음 검사
			sum = getMax(ay, ax, by, bx, fld, power);

			for (int t = 0; t < m; t++) {
				ay = ay + d[a[t]][0];
				ax = ax + d[a[t]][1];
				by = by + d[b[t]][0];
				bx = bx + d[b[t]][1];

				sum += getMax(ay, ax, by, bx, fld, power);
			}

			sb.append("#").append(itr).append(" ").append(sum);
			System.out.println(sb);
		}
	}
}
