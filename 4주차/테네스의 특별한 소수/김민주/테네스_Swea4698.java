package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 테네스_Swea4698 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		boolean [] so = new boolean[1000001];
		for(int i = 2; i<=1000000; i++) {
			for(int j = 2; j<i; j++) {
				if(i%j == 0) so[i] = true;
			}
		}
		
		for(int tc = 1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			String D = st.nextToken();
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int result = 0;	
			for (int i =A; i<=B; i++) {
				if(!so[i]) {
					if(Integer.toString(i).contains(D)) result++;
				}
			}
			System.out.println("#" + tc + " " + result);
		}
	}
}

//리스너는 감시
//핸들러는 수행







