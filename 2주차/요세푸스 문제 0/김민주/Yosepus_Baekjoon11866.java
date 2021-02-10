package com.ssafy.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Yosepus_Baekjoon11866 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Queue<Integer> yo = new LinkedList<Integer>();
		for (int i = 1; i <= N; i++) {
			yo.offer(i);
		}
		sb.append("<");
		while (!yo.isEmpty()) {
			for (int i = 1; i < K; i++) {
				yo.offer(yo.poll());
			}
			sb.append(yo.poll());
			if(!yo.isEmpty()) sb.append(", ");	
		}
		sb.append(">");
		System.out.println(sb);
	}
}
