package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부먹왕국_Swea7964 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int tc = 1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());
			int [] city = new int[N];
					
			st = new StringTokenizer(in.readLine());
			for(int i = 0; i<N; i++) {
				city[i] = Integer.parseInt(st.nextToken());
			}
			int add = 0;//설치한 차원관문의 수
			for(int i = 0; i<N; i++) {
				int cnt = 0;
				if(city[i] == 1) continue;
				else {
					for(int j = i+1; j<i+D ; j++) {//다음 도시부터 이동 제한 거리 내에 있는 도시 검사
						if(city[j] == 0) {
							cnt++;
						}
						else break; //이동 제한 거리 내에 차원관문 있으면 break
					}
					if(cnt == D-1) {//이동 제한 거리 내에 차원관문 없으면 
						city[i+D-1] = 1; //제일 끝에 차원관문 한개 세우기
						add++;
					}
				}
				
				
			}
			System.out.println("#" + tc + " " + add);
		}
	}
}
