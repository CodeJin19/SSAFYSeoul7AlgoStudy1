package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 팩토리얼0의개수_BJ1676 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		System.out.println(N/5+N/25+N/125);
		
	}

}
/*
 * 원래 5의 개수만큼 0이 붙는데, 5의 거듭제곱 일때 하나씩 더 붙음
 * 
 * 5: 1.2.3.4.5
 * 		5^1
 * 10: 1.2.3.4.5.6.7.8.9.10
 * 				5		5
 * 		5^2
 * 15: 1.2.3.4.5.6.7.8.9.10.11.12.13.14.15
 * 			   5		 5				5
 * 		5^3
 * 20:1.2.3.4.5.6.7.8.9.10.11.12.13.14.15.16.17.18.19.20
 * 			  5			5				5			  5
 * 		5^4
 * 
 * 25: 1.2.3.4.5.6.7.8.9.10.11.12.13.14.15.16.17.18.19.20.21.22.23.24.25
 * 		2	   5		2.5				3.5				2.2.5		   5.5
 * 		5^6
 * 125
 * 
 * 
 */
