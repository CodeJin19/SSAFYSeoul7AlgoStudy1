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


/*
 * +123456	      0			S+123456
 * -1234	   	+12345		W+12345
 * 12222+1234	-123		S+1234
 * 123456-12	12222+123	W+123
 * 123444+12	12345-1		S+12
 * 123456		12344+1		W+1
 * 					
 */
