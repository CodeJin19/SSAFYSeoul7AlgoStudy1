package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 계란으로계란치기_BJ16987 {

	static int N, cnt, max;
	static int[][] info;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		info= new int[N][2];
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			info[i][0] = Integer.parseInt(st.nextToken());
			info[i][1] = Integer.parseInt(st.nextToken());
		}
		//가장 왼쪽 계란을 든다
		dfs(0);
		System.out.println(max);
	}
	private static void dfs(int idx) {
		//제일 오른쪽에 위치한 계란일 경우 종료
		if(idx == N) {
			cnt = 0;
			for(int i=0; i<N; i++) {
				if(info[i][0]<=0) cnt++;
			}
			max = Math.max(max, cnt);
			return;
		}
		//들었는데 이미 깨져있다면 치지 않고 넘어간다
		if(info[idx][0] <= 0) dfs(idx+1); 
		
		//그게 아니라면,
		//손에 들고 있는 계란으로 깨지지 않은 다른 계란 중에서 하나를 친다.
		else {
			boolean flag = false;
			for(int i = 0; i<N; i++) {
				if(i == idx) continue;
				
				//이미 깨져있는 계란이라면
				if(info[i][0] <= 0) continue;
				info[idx][0] -= info[i][1];
				info[i][0] -= info[idx][1];
				flag = true;
				System.out.println(idx + " " + i);
				dfs(idx+1);
				info[idx][0] += info[i][1];//되돌려놓기
				info[i][0] += info[idx][1];
			}
			//깰 수 있는 계란 없으면 종료시킴
			if(!flag) dfs(N);
		}
		
	}
}
