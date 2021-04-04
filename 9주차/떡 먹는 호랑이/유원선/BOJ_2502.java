package com.ssafy.study;

import java.io.*;
import java.util.*;

public class BOJ_2502 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] A = new int[d + 1];
		int[] B = new int[d + 1];
		A[2] = 0; A[3] = 1;
		B[2] = 1; B[3] = 1;
		
		for (int i = 4; i <= d; i++) {
			A[i] = A[i - 1] + A[i - 2];
			B[i] = B[i - 1] + B[i - 2];
		}
		
		int a = 0, b = 0;
		for (int i = 1;; i++) {
			if ((k - A[d] * i) % B[d] == 0) {
				a = i;
				b = (k - A[d] * i) / B[d];
				break;
			}
		}
		
		System.out.println(a + "\n" + b);
	}

}
