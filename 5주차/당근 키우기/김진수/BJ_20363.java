package com.ssafy.algoStudy_05;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_20363 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int sum = x + y;
		
		if(x < y)
			sum += x / 10;
		else
			sum += y/ 10;
		
		System.out.println(sum);
	}
}
