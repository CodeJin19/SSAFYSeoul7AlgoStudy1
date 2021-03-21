package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 은하수_BJ15787 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int person[] = new int [N+1];
		boolean can[] = new boolean[1<<20];
		int cnt = 0;
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(in.readLine());
			int order = Integer.parseInt(st.nextToken());
			int train = Integer.parseInt(st.nextToken());
			int seat;
			switch(order) {
			case 1: // seat번째 앉아있던 사람 1로. OR연산
				seat = Integer.parseInt(st.nextToken());
				person[train] = person[train] | (1 << (seat-1));
				break;
			case 2: // seat번째 앉아있던 사람 0으로. AND연산
				seat = Integer.parseInt(st.nextToken());
				person[train] = person[train] &~ (1<<(seat-1));
				break;
			case 3: // 
				person[train] = person[train] << 1 ;
				person[train] &= ~(1<<20);
				break;
			case 4: // 
				person[train] = person[train] / 2;
				break;
			}
		}
		
		for(int i=1; i<N+1; i++) {
			if(!can[person[i]]) {
				can[person[i]] = true;
				cnt++;
			}
//			System.out.println(person[i]);
		}
		
		for(int i = 1; i<N+1; i++) {
			
		}
		
		System.out.println(cnt);
	}
}
