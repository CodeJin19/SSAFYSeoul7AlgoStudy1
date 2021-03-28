package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 근손실_BJ18429 {

	static int N, K, cnt;
	static int [] weight;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		weight = new int[N+1];
		st = new StringTokenizer(in.readLine());
		for(int i = 1; i<=N; i++) {
			weight[i] = Integer.parseInt(st.nextToken());
		}
		perm(1, new boolean[N+1], new int[N+1]);
		System.out.println(cnt);
	}
	
	private static void perm(int toSelect, boolean[] visited, int [] select) {
	
		if(toSelect > N) {
			count(select);
			return;
		}
		
		for(int i = 1; i<=N; i++) {
			if(!visited[i]) {
			visited[i] = true;
			select[toSelect] = i;
			perm(toSelect+1, visited, select);
			visited[i] = false;
			}
		}
		
		
	}
	
	private static void count(int [] select) {
		int w = 500;
		boolean flag = false;
		for(int i = 1; i<=N; i++) {
			w += weight[select[i]] -K;
			if(w<500) {
				flag = true;
				break;
			}
		}
		
		if(!flag) ++cnt;
	}
}
