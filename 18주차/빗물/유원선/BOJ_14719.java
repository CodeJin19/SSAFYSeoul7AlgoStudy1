package com.ssafy.study;

import java.io.*;
import java.util.*;

public class BOJ_14719 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		Stack<Integer> stack = new Stack<>();
		Queue<Integer> q = new LinkedList<>();
		
		int sum = 0, max_height= 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < w; i++) {
			int height = Integer.parseInt(st.nextToken());
			if (stack.isEmpty()) {
				stack.push(height);
				max_height = height;
			}
			else {
				int cur_height = Math.min(max_height, height); // 채워야 할 높이 기준 구하기
				while (stack.peek() < cur_height) {
					q.add(stack.pop());
				}
				
				// 빗물 채우는 작업
				while (!q.isEmpty()) {
					sum += cur_height - q.poll(); // 채워지는 빗물 양만큼 더하기
					stack.push(cur_height);
				}
				
				stack.push(height); // 원래 넣어야 할 높이 넣기
			}
			
			max_height = Math.max(max_height, height); // 최대 높이 갱신 
		}
		
		System.out.println(sum);
	}

}
