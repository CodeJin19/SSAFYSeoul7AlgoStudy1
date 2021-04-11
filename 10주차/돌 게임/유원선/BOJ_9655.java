package com.ssafy.study;

import java.io.*;

public class BOJ_9655 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		System.out.println(n % 2 == 0 ? "CY" : "SK");
	}

}
