package com.ssafy.algoStudy_04;

import java.io.*;
import java.util.StringTokenizer;

public class SWEA_6485 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;
		int T = Integer.parseInt(reader.readLine());
		int cnt[];
		int n, p, from, to;

		for (int itr = 1; itr <= T; itr++) {
			cnt = new int[5010];
			sb = new StringBuilder();
			sb.append("#").append(itr);

			n = Integer.parseInt(reader.readLine());

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(reader.readLine());

				from = Integer.parseInt(st.nextToken());
				to = Integer.parseInt(st.nextToken());

				for (int j = from; j <= to; j++)
					cnt[j]++;
			}

			p = Integer.parseInt(reader.readLine());

			for (int i = 0; i < p; i++) {
				sb.append(" ").append(cnt[Integer.parseInt(reader.readLine())]);
			}

			System.out.println(sb);
		}
	}
}
