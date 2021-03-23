package com.ssafy.algoStudy_04;

import java.io.*;

public class SWEA_5356 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(reader.readLine());
		StringBuilder sb;
		String list[] = new String[5];
		int len[] = new int[5];
		int max;

		for (int itr = 1; itr <= T; itr++) {
			sb = new StringBuilder();
			sb.append("#").append(itr).append(" ");

			max = 0;

			for (int i = 0; i < 5; i++) {
				list[i] = reader.readLine();
				len[i] = list[i].length();
				max = Math.max(max, len[i]);
			}

			for (int i = 0; i < max; i++)
				for (int j = 0; j < 5; j++)
					if (i < len[j])
						sb.append(list[j].charAt(i));

			System.out.println(sb);
		}
	}
}
