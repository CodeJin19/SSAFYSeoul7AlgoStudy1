package com.ssafy.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.List;
//import java.util.Queue;
import java.util.StringTokenizer;

public class Ballon_Baekjoon2346 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		Deque<int []> ba = new ArrayDeque<>(); //큐{풍선 안에 있던 값, 풍선 번호}
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i<=N; i++) {
			ba.add(new int[] {Integer.parseInt(st.nextToken()),i}) ;
		}
		
		while(true) {
			int k = ba.peek()[0];//제일 끝에 있는 값 빼기
			sb.append(ba.poll()[1]).append(" "); // 풍선 번호 출력
			if(ba.isEmpty()) break;
			
			if(k>0) { //풍선 안에 있던 값이 양수라면
				k--;
				while(k-->0)
					ba.offer(ba.poll());
			}
			
			else if(k<0) { //풍선 안에 있던 값이 음수라면
				k=k*(-1); // 양수로 만들어서
				while(k-- > 0) {
					ba.offerFirst(ba.pollLast());
				}
				
			}
		}
//		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}
}






