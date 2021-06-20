package com.ssafy.study;

import java.io.*;
import java.util.*;

public class BOJ_16953 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int cnt = 1;
		while (b != a) {
			if (b < a) {
				System.out.println(-1);
				return;
			}
			
			if (b % 2 == 0) {
				b /= 2;
			}
			else {
				String tmp = String.valueOf(b);
				int lastNum = Integer.parseInt(tmp.substring(tmp.length() - 1));
				if (lastNum == 1) {
					tmp = tmp.substring(0, tmp.length() - 1);
					b = Integer.parseInt(tmp);
				}
				else if (b != a) {
					System.out.println(-1);
					return;
				}
			}
			
			cnt++;
		}
		
		System.out.println(cnt);
	}

}
