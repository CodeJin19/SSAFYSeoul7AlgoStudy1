package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 주유소_BJ13305 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		long [] dis = new long[N-1];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i = 0; i<N-1; i++) {
			dis[i] = Long.parseLong(st.nextToken()); 
		}
		
		st = new StringTokenizer(in.readLine());
		long cost = Long.parseLong(st.nextToken());
		long sum = dis[0] * cost;
		
		for(int i = 1; i<N-1; i++) {
			long c = Long.parseLong(st.nextToken());
			if(cost > c)
				cost = c;
			sum += dis[i]*cost;
		}
		System.out.println(sum);
	}
}
