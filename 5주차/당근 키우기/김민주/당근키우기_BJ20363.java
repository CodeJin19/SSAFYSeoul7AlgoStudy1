package com.ssafy.baekjoon;

import java.util.Scanner;

public class 당근키우기_BJ20363 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();
		int Y = sc.nextInt();
		if(X>=Y) System.out.println(X+Y+Y/10);
		else System.out.println(Y+X+X/10);
		sc.close();
	}
}


