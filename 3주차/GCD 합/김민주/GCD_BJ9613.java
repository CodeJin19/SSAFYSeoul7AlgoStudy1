package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GCD_BJ9613 {

	static long sum;
	static int n;
	static int [] num;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for(int tc = 1; tc<=T; tc++) {
			sum = 0;
			String str = in.readLine();
			StringTokenizer st = new StringTokenizer(str);
			n = Integer.parseInt(st.nextToken());
			num = new int[n];
			for(int i = 0; i<n; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			comb(0, new int[2], 0);
			sb.append(sum).append("\n");
			
		}
		System.out.print(sb);
		
	}
	
	private static void comb(int toSelect, int[] selected, int startIdx) {
		if(toSelect == 2) {
			sum += gcd(selected[0], selected[1]);
			return;
		}
		for (int i = startIdx; i < n; i++) {
			selected[toSelect] = num[i];
			comb(toSelect+1, selected, i+1);
		}
	}
	
	private static int gcd(int a, int b) {
		if(b==0) {
			return a;
		}
		else return gcd(b,a%b);
	}
}
