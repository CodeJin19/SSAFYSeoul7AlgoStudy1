package com.ssafy.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class AC_BJ5430 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringBuilder sb = new StringBuilder();
			String p = in.readLine(); // 수행할 함수
			int n = Integer.parseInt(in.readLine()); // 배열에 들어있는 수의 개수
			String arr = in.readLine();
			LinkedList<Integer> num = new LinkedList<Integer>();
			String subarr = arr.substring(1, arr.length() - 1);
			int cnt = 0;
			boolean empty = false;
		
			if(n != 0) { //숫자가 있다면 num에 저장
			StringTokenizer st = new StringTokenizer(subarr, ",");
				while (st.hasMoreTokens()) {
					num.offer(Integer.parseInt(st.nextToken()));
				}
			}
//			else { // 숫자가 하나도 없는데 D가 없다면 []출력
//				if(!p.contains("D")) {
//					empty = true;
//					sb.append("[]");
//				}
//			}
			
			for (int i = 0; i < p.length(); i++) {
				if(p.charAt(i)=='R') 
					cnt++; // R이 나오면 cnt증가
				
				else if(p.charAt(i)=='D'){ // 'D'가 나오면
					if (num.isEmpty()) { //비어있으면 error 출력
						sb.append("error");
						empty = true; //flase -> true로
						break;
					}
					if (cnt % 2 != 0) // R개수가 홀수면 num 뒤에서 한개 삭제
						num.pollLast();
					else
						num.poll(); // R개수가 짝수면 앞에서 한개 삭제
				}
			}

			if (!empty) { // 배열이 비어있지 않을때(false)
				sb.append("[");
				if (cnt % 2 != 0) { // R의 개수가 홀수개면 뒤에서부터 출력
					while (!num.isEmpty()) {
						sb.append(num.pollLast()).append(",");
					}
				} 
				else { //R의 개수가 짝수라면 앞에서부터 출력
					while (!num.isEmpty()) {
						sb.append(num.poll()).append(",");
					}
				}
				if(sb.length()>1) sb.setLength(sb.length() - 1);
				sb.append("]");
			}
			System.out.println(sb);
		}
	}
}
