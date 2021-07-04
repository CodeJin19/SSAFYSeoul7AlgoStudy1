package com.ssafy.study;

import java.io.*;

public class BOJ_1484 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int g = Integer.parseInt(br.readLine());
		
		long prev = 1, cur = 2;
		boolean flag = false;
		while (prev < cur) {
			long diff = cur * cur - prev * prev;

			if (diff == g) {
				flag = true;
				System.out.println(cur);
			}
			
			if (diff <= g) cur++;
			else prev++;
		}
		
		if (!flag) System.out.println(-1);
	}

}
