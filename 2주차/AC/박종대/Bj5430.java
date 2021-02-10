package bj5430;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;


/*
 * 진짜 문제 설명대로 일일이 배열 뒤집으면 시간 초과가 날테니 데큐를 사용했음
 * 현재 방향이 정방향이면 앞에서부터 제거, 역방향이면 뒤에서부터 제거
 * 
 * 문자열.replace("A", "B");   // 문자열에서 A를 찾아서 B로 바꿈
 * "[11".replace("[", ""); // '['를 공백으로 바꿔서 제거
 */


public class Bj5430 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 0; test_case < T; test_case++) {
			
			boolean check = true;
			boolean direction = true; //정방향이면 true, 역방향 false
			String function = br.readLine();
			
			int size = Integer.parseInt(br.readLine());
			
			String numArr[] = br.readLine().split(",");
			
			numArr[0] = numArr[0].replace("[", "");
			
			if (size > 0)
				numArr[size-1] = numArr[size-1].replace("]", "");
			else
				numArr[0] = numArr[0].replace("]", "");
		
			Deque<String> queue = new LinkedList<String>();
			
			for (String string : numArr) {
				queue.offer(string);
			}
			
			Loop:
			for (int i = 0; i < function.length(); i++) {
				switch(function.charAt(i)) {
				case 'R':
					direction = direction? false:true;
					break;
				case 'D':
					if (size == 0) {
						check = false;
						break Loop; // error나면 for문 취소
					}
					
					if (direction) {
						queue.pollFirst();
						size--;
					}
					else {
						queue.pollLast();
						size--;
					}
				}
			}
			
			if (!check) {
				System.out.println("error");
				continue;
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append("[");
			
			if(!queue.isEmpty()) {
				// 정방향이면 큐의 앞에서부터 출력
				if (direction) {
					sb.append(queue.pollFirst());
					
					while (!queue.isEmpty()) {
						sb.append(",").append(queue.pollFirst());
					}
					
				}
				else { // 역방향이면 큐의 뒤에서부터 출력
					sb.append(queue.pollLast());
					
					while (!queue.isEmpty()) {
						sb.append(",").append(queue.pollLast());
					}
					
				}
			}
			
			sb.append("]");
			System.out.println(sb);
		}
	}

}
