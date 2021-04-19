package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 월드컵_BJ6987 {

	// A팀 vs B팀
	// 승	   패
	// 무	   무
	// 패	   승
	
	// A vs B, C, D, E, F
	// B vs C, D, E, F
	// C vs D, E, F
	// D vs E, F
	// E vs F
	
	static int [] t1 = {0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 4};
	static int [] t2 = {1, 2, 3, 4, 5, 2, 3, 4, 5, 3, 4, 5, 4, 5, 5};
	static int [] win = new int[6];
	static int [] lose = new int[6];
	static int [] draw = new int[6];
	static boolean flag;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<4; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			flag = false;
			int w = 0, d = 0, l = 0;
			for(int j = 0; j<6; j++) {
				w += win[j] = Integer.parseInt(st.nextToken()); //승
				d += draw[j] = Integer.parseInt(st.nextToken()); //무
				l += lose[j] = Integer.parseInt(st.nextToken()); //패
			}
			if(w+d+l != 30) flag = false;
			else check(0);
			sb.append(flag ? 1 : 0).append(" ");
		}
		System.out.println(sb.toString());
	}
	
	private static void check(int game) {
		if(game == 15) {
			flag = true;
			return;
		}
		int a = t1[game];
		int b = t2[game];
		
		//A 승 B 패
		if(win[a] > 0 && lose[b] > 0) {
			win[a]--;
			lose[b]--;
			check(game+1);
			win[a]++;
			lose[b]++;
		}
		
		//A 패 B 승
		if(lose[a] > 0 && win[b] > 0) {
			lose[a]--;
			win[b]--;
			check(game+1);
			lose[a]++;
			win[b]++;
		}
		//A 무 B 무
		if(draw[a] > 0 && draw[b] > 0) {
			draw[a]--;
			draw[b]--;
			check(game+1);
			draw[a]++;
			draw[b]++;
		}
		
	
	}
}
