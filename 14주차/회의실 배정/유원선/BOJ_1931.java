package com.ssafy.study;

import java.io.*;
import java.util.*;

public class BOJ_1931 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
        
		List<int[]> list = new ArrayList<>(); 
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			list.add(new int[] {start,end});
		}
        
        Collections.sort(list, (a, b) -> (a[1] == b[1]) ? a[0] - b[0] : a[1] - b[1]);
        int prev_end = 0, cnt = 0;
        for (int[] cur : list) {
        	if (cur[0] >= prev_end) {
        		cnt++;
        		prev_end = cur[1];
        	}
        }
        
        System.out.println(cnt);
	}

}
