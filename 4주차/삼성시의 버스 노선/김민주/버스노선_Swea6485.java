package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 버스노선_Swea6485 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(in.readLine());
			int bus[] = new int[5001];
			for(int i = 1; i<=N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				for(int j = a; j<=b; j++)
					bus[j]++;
				
			}
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			
			int P = Integer.parseInt(in.readLine());
			for(int i = 1; i<=P; i++) {
				sb.append(bus[Integer.parseInt(in.readLine())]).append(" ");
			}
			System.out.println(sb);
		}
	}
}
