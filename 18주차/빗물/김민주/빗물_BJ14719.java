package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 빗물_BJ14719 {

	static int H, W;
	static int [] map;
	static boolean [][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		map = new int[W];
		visited = new boolean[H][W];
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i<W; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		
		int cnt = 0;
		for(int i = 1; i<W-1; i++) {
			int left=0, right = 0;
			for(int l = i-1; l>=0; l--) {
				left = Math.max(left, map[l]);
			}
			for(int r = i+1; r<W; r++) {
				right = Math.max(right, map[r]);
			}
			int val = (left >= right) ? right : left;
			if(val >= map[i]) {
//				무쓸모 visited
//				for(int j = map[i]; j<val; j++) {
//					if(!visited[j][i]) {
//						cnt++;
//						visited[j][i] = true;
//					}
//				}
				cnt += val-map[i];
			}
		}
//		for(int i = 0; i<H; i++) {
//			for(int j = 0; j<W; j++) {
//				if(visited[i][j]) {
//					System.out.print("1");
//				} else System.out.print("0");
//			}
//			System.out.println();
//		}
		System.out.println(cnt);
	}
}
