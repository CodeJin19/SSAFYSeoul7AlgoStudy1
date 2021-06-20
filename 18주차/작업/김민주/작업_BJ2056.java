package com.ssafy.baekjoon;

import java.io.*;
import java.util.*;

public class 작업_BJ2056 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int [] time = new int[N+1]; //작업 시간만 저장
		int [] dp = new int[N+1]; //각 작업이 끝나는 시간 저장
		ArrayList<ArrayList<Integer>> pre = new ArrayList<>(); //선행 작업번호 저장->저장 안해줘도 됨!
		
		for(int i = 1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			pre.add(new ArrayList<>());
			for(int j = 0; j<n; j++) {
				pre.get(i-1).add(Integer.parseInt(st.nextToken()));
			}
		}
		
		int result = 0;
		
		for(int i = 1; i<=N; i++) {
			int maxWork = 0;
			int size = pre.get(i-1).size();
			for(int s = 0; s<size; s++) {
				maxWork = Math.max(maxWork, dp[pre.get(i-1).get(s)]);//선행작업들 중 가장 오래 걸리는 시간 고르기
			}
			dp[i] = maxWork + time[i]; //선행작업시간 + 내 작업 시간
			result = Math.max(result, dp[i]); //가장 나중에 끝나는 작업시간 저장
		}
		System.out.println(result);
	}
}
