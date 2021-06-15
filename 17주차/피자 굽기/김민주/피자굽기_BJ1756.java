package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 피자굽기_BJ1756 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int D = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int [] oven = new int [D+1];
		int [] pizza = new int [N];
		int count = 0;
		int result = 0;
		
		st = new StringTokenizer(in.readLine());
		oven[1] = Integer.parseInt(st.nextToken());
		//윗칸의 지름보다 작으면 윗칸의 지름으로 세팅
		for(int i = 2; i<=D ; i++) {
			oven[i] = Math.min(oven[i-1], Integer.parseInt(st.nextToken()));
		}
		
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i<N; i++) {
			pizza[i] = Integer.parseInt(st.nextToken());
		}
		
		// 밑에서부터 비교
		for(int d = D; d>0; d--) {
			if(pizza[count] <= oven[d]) {//피자가 오븐 안에 들어가면
				count++; //다음 피자 검사
				result = d; //위치 바꿔놓기
			}
			if(count == N) break; //전체 다 들어갔으면 끝
		}
		
		if(count != N) result = 0; //전체 다 못들어가면 0출력
		
		System.out.println(result);
	}
}
