package com.ssafy.algoStudy_04;

import java.io.*;
import java.util.StringTokenizer;

public class SWEA_4698 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;
		int T = Integer.parseInt(reader.readLine());
		int d, a, b, cnt;
		boolean isPrime[] = new boolean[1000010];

		for (int i = 2; i <= 1000000; i++) {
			isPrime[i] = true;
		}

		for (int i = 2; i <= 1000000; i++) {
			if (isPrime[i]) {
				for (int j = i + i; j <= 1000000;) {
					isPrime[j] = false;
					j += i;
				}
			}
		}

		for (int itr = 1; itr <= T; itr++) {
			sb = new StringBuilder();
			st = new StringTokenizer(reader.readLine());
			d = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			cnt = 0;

			for (int i = a; i <= b; i++)
				if (isPrime[i] && isThere(i, d))
					cnt++;

			sb.append("#").append(itr).append(" ").append(cnt);
			System.out.println(sb);
		}
	}

	private static boolean isThere(int num, int d) {
		while (num != 0) {
			if (num % 10 == d)
				return true;
			num /= 10;
		}

		return false;
	}
}
