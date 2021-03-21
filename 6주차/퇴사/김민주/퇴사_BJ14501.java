package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 퇴사_BJ14501 {

	static int N, max = 0;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		arr = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		leave(0, 0);
		System.out.println(max);
	}

	private static void leave(int day, int sum) {
		if (day >= N) {
			max = Math.max(max, sum);
			return;
		}
		
		if (day + arr[day][0] <= N) //기간이 퇴사일 전이면
			leave(day + arr[day][0], sum + arr[day][1]); //날짜도 더하고, 금액도 더하고
		else//퇴사일 넘어가면
			leave(day + arr[day][0], sum); //날짜만 더하기
		
		leave(day + 1, sum); //DFS로 탐색

	}
}
