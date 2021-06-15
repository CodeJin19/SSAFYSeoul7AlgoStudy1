package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 세용액_BJ2473 {

	static int n;
	static long [] sol;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		sol = new long[n];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i = 0; i<n; i++) {
			sol[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(sol);
		long result = Long.MAX_VALUE;
		long [] num = new long[3];
		
		for(int i = 0; i<n; i++) {
			long one = sol[i];
			int left = i+1;
			int right = n-1;
			
			while(true) {
				if(left >= right) break;
				long two =  sol[left];
				long three = sol[right];
				long val = one + two + three;
				if(result > Math.abs(val)) {
					result = Math.abs(val);
					num[0] = one;
					num[1] = two;
					num[2] = three;
				}
				if(val > 0) right--;
				else left++;
			}
			
		}
		Arrays.sort(num);
		System.out.println(num[0] + " " + num[1] + " " + num[2]);
	}
}
