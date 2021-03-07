package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 공연기획_Swea4789 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; t++) {
			String str = in.readLine();
			int sum = 0;
			int add = 0;
			for (int i = 0; i < str.length(); i++) {
				int people = str.charAt(i)-'0';
				if(people==0) continue;
				
				if(sum >= i) sum += people;
				else {
					add += i-sum;
					sum = i + people;
//					 sum += i-sum + people;
				}
				
			}

			System.out.println("#" + t + " " + add);
		}
	}
}
