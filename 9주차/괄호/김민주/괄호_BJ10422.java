package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 괄호_BJ10422 {
	/*
	 * 2 : () : 1 
	 * 4: (()) ()() :2 
	 * 6: ((())) (())() ()(()) (()()) ()()() :5 
	 * 8:
	 * (((()))) ((()())) ((())()) (()(())) (()()()) : 14 
	 * ((()))() (()())() ()((()))
	 * ()(()()) (())()() (())(()) ()()(()) ()(())() ()()()()
	 * 
	 * 
	 * 10: 14 41 113 131 311 122 212 221 1112 1121 1211 2111 11111:13 
	 * ((((()))))
	 * (((()()))) ((()()())) (()()()()) ()(((()))) ()((()())) ()(()()()) (((())))()
	 * ((()()))() (()()())() : ()()((())) ()()(()()) ((()))()() (()())()()
	 * ()()()(()) ()()(())() ()(())()() (())()()() ()()()()()
	 * 
	 * 
	 * 
	 */

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());

		long[] val = new long[5001];
		val[0] = 1;
		for (int i = 2; i <= 5000; i += 2) {
			for (int j = 0; j < i; j += 2) {
				val[i] += val[j] * val[i - 2 - j];
				val[i] %= 1000000007;
			}
		}

		for (int tc = 1; tc <= T; tc++) {
			int L = Integer.parseInt(in.readLine());

			System.out.println(val[L]);

		}
	}
}
