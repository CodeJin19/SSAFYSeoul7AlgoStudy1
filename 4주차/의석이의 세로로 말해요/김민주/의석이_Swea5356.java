package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 의석이_Swea5356 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int tc = 1; tc<= T; tc++) {
			StringBuilder sb = new StringBuilder();
			char [][] ch = new char[5][15];
			for(int i = 0; i<5; i++) {
				String str = in.readLine();
				for(int j = 0; j<str.length(); j++) {
					ch[i][j] = str.charAt(j);
				}
			}
			sb.append("#").append(tc).append(" ");
			for(int j = 0; j<15; j++) {
				for(int i = 0; i<5; i++) {
					if(ch[i][j] == 0) continue;
					sb.append(ch[i][j]);
				}
			}
			System.out.println(sb);
			
		}
	}
}
