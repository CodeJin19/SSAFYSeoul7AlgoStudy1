package com.ssafy.algoStudy_04;

import java.io.*;

public class SWEA_4789 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;
		String str;
		int T = Integer.parseInt(reader.readLine());
		int sum, cnt, n, len;

		for (int itr = 1; itr <= T; itr++) {
			sb = new StringBuilder();
			str = reader.readLine();
			len = str.length();
			sum = 0;
			cnt = 0;

			for (int i = 0; i < len; i++) {
				n = (int) (str.charAt(i) - '0');

				if (n == 0)
					continue;

				if (i <= sum) {
					sum += n;
				} else {
					cnt += (i - sum);
					sum = i + n;
				}
			}

			sb.append("#").append(itr).append(" ").append(cnt);
			System.out.println(sb);
		}
	}
}
