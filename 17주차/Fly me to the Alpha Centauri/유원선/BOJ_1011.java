package com.ssafy.study;

import java.io.*;
import java.util.*;

/*
 *  차이 1	2	3	4	5	6	7 	8	9	10	11	12	13 ...
 *  횟수 1	2	3	3	4	4	5	5	5	6	6	6	7  ...
 *  
 *  횟수 1	2	3	4	5	6	7	8	9 ...
 *  개수 1	1	2	2	3	3	4	4	5 ...
 */
public class BOJ_1011 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int diff = y - x;
			
			int cnt = 1;
			long sum = 0;
			while (true) {
				sum += (cnt % 2 == 0) ? cnt / 2 : cnt / 2 + 1;
				if (diff <= sum) {
					System.out.println(cnt);
					break;
				}
				cnt++;
			}
		}
	}

}
