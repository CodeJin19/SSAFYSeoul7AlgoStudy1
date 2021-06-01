package com.ssafy.study;

import java.io.*;
import java.util.*;

public class BOJ_20191 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		String t = br.readLine();
		
		List<Integer>[] alpha = new ArrayList[26];
		for (int i = 0; i < 26; i++)
			alpha[i] = new ArrayList<>();
		
		for (int i = 0; i < t.length(); i++) 
			alpha[t.charAt(i) - 'a'].add(i);
		
		int pos = -1;
		int ans = 1;
		
		for (int i = 0; i < s.length(); i++) {
			int which = s.charAt(i) - 'a';
			int left = 0, right = alpha[which].size();
			if (right == 0) {
				System.out.println(-1);
				return;
			}
			
			while (left < right) {
				int mid = (left + right) / 2;
				int mid_val = alpha[which].get(mid);
				
				if (mid_val <= pos) {
					left = mid + 1;
				} else {
					right = mid;
				}
			}
			pos = left;
			
			if (pos == alpha[which].size()) {
				ans++;
				pos = 0;
			}
			
			pos = alpha[which].get(pos);
		}
		
		System.out.println(ans);
	}

}
