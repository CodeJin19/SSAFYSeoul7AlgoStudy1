package com.ssafy.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class 거꾸로구구단_BJ13410 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		sc.close();
		int [] arr = new int[K+1];
		for(int i = 1; i<=K; i++) {
			StringBuilder sb = new StringBuilder();
			String result = Integer.toString(N*i);
			int len = result.length();
			for(int k = 1; k<=len; k++) {
				sb.append(result.charAt(len-k));
			}
			arr[i] = Integer.parseInt(sb.toString());
		}
		Arrays.sort(arr);
		System.out.println(arr[arr.length-1]);
	}	
}
