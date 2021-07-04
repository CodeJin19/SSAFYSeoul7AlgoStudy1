package com.ssafy.study;

import java.io.*;
import java.util.*;

public class BOJ_10434 {

	static final int N = 10000;
	static int[] prime = new int[N+1];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		setPrime();
		
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int tc = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			
			sb.append(tc).append(" ").append(num).append(" ");
			if (prime[num] == 0) {
				sb.append("NO").append('\n');
				continue;
			}
			
			if (isHappyPrime(num))
				sb.append("YES");
			else
				sb.append("NO");
			
			sb.append('\n');
		}
		
		System.out.println(sb);
	}
	
	static boolean isHappyPrime(int num) {
		boolean[] cache = new boolean[N+1];

		while (!cache[num]) {
			cache[num] = true;
			int val = num, nextNum = 0;
			while (val != 0) {
				int na = val % 10;
				nextNum += na * na;
				val /= 10;
			}

			if (nextNum == 1) 
				return true;
			
			num = nextNum;
		}
		
		return false;
	}
	
	static void setPrime() {
		for (int i = 2; i <= N; i++) prime[i] = i;
		
		for (int i = 2; i <= N; i++) {
			if (prime[i] == 0) continue;
			for (int j = i + i; j <= N; j += i) {
				if (prime[j] != 0)
					prime[j] = 0;
			}
		}
	}

}
