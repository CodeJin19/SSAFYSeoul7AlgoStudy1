package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 여왕벌_BJ10836 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int bug[] = new int [2*M-1];
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			int zero = Integer.parseInt(st.nextToken());
			int one = Integer.parseInt(st.nextToken());
			int a = zero+one;
			for(int j = zero; j<a; j++)
				bug[j] += 1;
			
			int two = Integer.parseInt(st.nextToken());
			int b = zero+one+two;
			for(int j = a; j<b; j++)
				bug[j] += 2;
		}
		
		for(int i = 0; i<M; i++) {
			sb.append(bug[M-1-i]+1).append(" ");
			for(int j = M; j<2*M-1; j++) {
				sb.append(bug[j]+1).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}


/*
 * bug[M-1]  bug[M]	 bug[M+1]  bug[M+2] ... bug[2M-2]	
 * bug[M-2]  bug[M]	 bug[M+1]  bug[M+2] ... bug[2M-2]	
 * bug[M-3]  bug[M]	 bug[M+1]  bug[M+2] ... bug[2M-2]	
 * .		
 * .
 * bug[1]
 * bug[0]    bug[M]	 bug[M+1]  bug[M+2] ... bug[2M-2]	
 */
