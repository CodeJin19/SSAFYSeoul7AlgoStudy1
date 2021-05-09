package com.ssafy.baekjoon;

import java.io.*;
import java.util.*;

public class 거짓말_BJ1043 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine());
		int t = Integer.parseInt(st.nextToken());
		boolean [] people = new boolean[N+1];
		for(int i=0; i<t; i++) {
			int num = Integer.parseInt(st.nextToken());
			people[num] = true; // 처음에 진실을 알고 있었던 사람 true
		}
		
		int party[][] = new int[M+1][N+1];
		int sum = 0;
		
		for(int m = 1; m <= M; m++) {
			st = new StringTokenizer(in.readLine());
			int p = Integer.parseInt(st.nextToken());
			for(int i = 0; i<p; i++	) {
				party[m][i] = Integer.parseInt(st.nextToken());//[m번째 파티][]=왔던 사람들 저장
			}
	
			for(int i = 0; i<p; i++) { // m번째 파티에 왔던 사람들 모두 검사
				if(people[party[m][i]]) {  // m번째 파티에 왔던 사람이 진실을 알고 있는 사람이라면
					for(int j = 0; j<p; j++) { // 파티에 왔던 사람들 처음부터 돌면서
						people[party[m][j]] = true; // 모두 true로 바꿔줌
					}
					break;
				}
			}
		}
		
		int pNum = M;
		while(pNum-->0) { //파티 개수M만큼 계속 검사
			for(int m = 1; m <= M; m++) {
				for(int i = 0; party[m][i]!=0; i++) { // m번째 파티에 왔던 사람들 모두 검사
					if(people[party[m][i]]) {  // m번째 파티에 왔던 사람이 진실을 알고 있는 사람이라면
						for(int j = 0; party[m][j]!=0; j++) { // 파티에 왔던 사람들 처음부터 돌면서
							people[party[m][j]] = true; // 모두 true로 바꿔줌
						}
						break;
					}
				}
			}
		}
		
		for(int m = 1; m <= M; m++) {
			boolean flag = false;
			for(int i = 0; party[m][i]!=0; i++) { // m번째 파티에 왔던 사람들 모두 검사
				if(people[party[m][i]]) {  // m번째 파티에 왔던 사람이 진실을 알고 있는 사람이라면
					flag = true;
					break;
				}
			}
			if(!flag) sum++; 
		}
		
		System.out.println(sum);
	}
}

/*반례
4 3
1 2
1 3 
2 1 3
2 1 2
(답:0)

4 3 
1 1
2 1 2
1 2
2 3 4
(답: 1)
*/