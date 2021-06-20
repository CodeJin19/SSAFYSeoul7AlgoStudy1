package com.ssafy.baekjoon;

import java.io.*;
import java.util.*;

public class AB_BJ16953 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int cnt = 0;
		while(B != A) {
			if(B<A) {
				cnt = -2;
				break;
			}
			
			if(B%10 != 1 && B%2 != 0) {
				cnt = -2;
				break;
			}
			
			if(B%10 == 1) B=B/10;
			else B=B/2;
				
			cnt++;
		}
		
		System.out.println(cnt+1);
	}
}
