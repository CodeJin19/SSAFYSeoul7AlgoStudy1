
package com.ssafy.programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 큰수만들기_PG42883 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		String number = in.readLine();
		int k = Integer.parseInt(in.readLine());
		int len = number.length();
		int x = len-k;
		int start = 0;
		for(int i = 0; i<x; i++){
			int max = -1;
			for(int j = start; j<=i+k; j++) {
				if(max < number.charAt(j)-'0') {
					max = number.charAt(j)-'0';
					start = j+1;
				}
			}
			answer.append(max);
		}
		System.out.println(answer);
	}
}





