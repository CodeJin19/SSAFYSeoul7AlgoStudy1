package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 선발명단_BJ3980 {

	static boolean []position;
	static int max, sum;
	static int [][] player;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int tc = 1; tc<=T; tc ++) {
			player = new int [11][11];
			max = 0;
			
			for(int i = 0; i<11; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				for(int j = 0; j<11; j++) {
					player[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			perm(0, new boolean[11], new int[11]);
			System.out.println(max);
		}
	}
	
	public static void perm(int toSelect, boolean [] visited, int []selected) {
		if(toSelect == 11) {
			sum=0;
			position(selected);
			max = Math.max(max, sum);
			return;
		}
		
		for(int i = 0; i<11; i++) {
			if(player[i][toSelect] == 0) continue;
			if(!visited[i]) {
				visited[i] = true;
				selected[i] = toSelect;
				perm(toSelect+1, visited, selected);
				visited[i] = false;
			}
		}
	}
	
	public static void position(int [] selected) {
		for(int i = 0; i<11; i++) {
			sum += player[i][selected[i]];
		}
	}
}
