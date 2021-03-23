package com.ssafy.algoStudy_04;

import java.io.*;
import java.util.StringTokenizer;

public class SWEA_7964 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;

		int T = Integer.parseInt(reader.readLine());
		int n, l, cnt, total;
		boolean map[];

		for (int itr = 1; itr <= T; itr++) {
			sb = new StringBuilder();
			st = new StringTokenizer(reader.readLine());

			n = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());
			total = 0;

			st = new StringTokenizer(reader.readLine());
			map = new boolean[n + 1];
			map[0] = true;
			
			for (int i = 1; i <= n; i++)
				if (st.nextToken().charAt(0) == '1')
					map[i] = true;
				else
					map[i] = false;
			
			cnt = 0;

			for (int i = 1; i <= n; i++) {
				if (!map[i])
					cnt++;
                else
                    cnt = 0;

				if (cnt == l) {
					total++;
					cnt = 0;
				}
			}

			sb.append("#").append(itr).append(" ").append(total);
			System.out.println(sb);
		}
	}
}
