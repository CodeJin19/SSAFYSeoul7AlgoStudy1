package com.ssafy.study;

import java.io.*;
import java.util.*;

public class BOJ_7573_2 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		List<int[]> point = new ArrayList<>();
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			point.add(new int[] {x,y});
		}
		
		int max = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				int[] f1 = point.get(i), f2 = point.get(j);
				for (int a = 1; a < l/2; a++) {
					int b = l/2 - a;
					
					int cnt = 0;
					for (int k = 0; k < m; k++) {
						int[] f = point.get(k);
						if (f1[0] <= f[0] && f[0] <= f1[0]+a
								&& f2[1] <= f[1] && f[1] <= f2[1]+b)
							cnt++;
					}
					
					max = Math.max(max, cnt);
				}
			}
		}

		System.out.println(max);
	}

}
