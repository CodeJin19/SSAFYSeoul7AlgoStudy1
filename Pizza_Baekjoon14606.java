package com.ssafy.study;

import java.util.Scanner;
//분할정복정렬
public class Pizza_Baekjoon14606 {

	static int N, sum;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		System.out.println(pizza(N));
		sc.close();
	}

	private static int pizza(int n) {
		if (n ==1) 
			return 0;
		int A = n/2;
		int B = n - A;
		sum = A*B;
		return sum += pizza(n-n/2) + pizza(n/2);

	}
}
