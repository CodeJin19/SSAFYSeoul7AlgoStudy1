package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 듣보잡_BJ1764 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<String> arr = new ArrayList<String>();
		int cnt = 0;
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<N; i++) {
			hm.put(in.readLine(), 0);
		}
		for(int i = 0; i<M; i++) {
			String str = in.readLine();
			if(hm.containsKey(str)) {
				arr.add(str);
				cnt++;
				
			}
		}

		Collections.sort(arr);
		sb.append(cnt).append("\n");
		for(int i =0; i<cnt; i++) {
			sb.append(arr.get(i)).append("\n");
		}
		
		System.out.println(sb);
	}
}
