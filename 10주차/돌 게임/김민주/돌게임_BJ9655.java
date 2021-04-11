package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 돌게임_BJ9655 {
/*
 * 1 1 1 1 1: 상근
 * 1 3 1 : 상근
 * 3 1 1 : 상근
 * 1 1:
 * 1 1 1 1 1 1:상근
 * 1 3 1 3 : 창영
 * 
 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		if(N%2 == 0) System.out.println("CY");
		else System.out.println("SK");
	}
}
