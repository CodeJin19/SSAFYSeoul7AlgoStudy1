package com.ssafy.study;

import java.io.*;

public class BOJ_16472 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] alpha = new int[26];
		char[] str = br.readLine().toCharArray();
		
		int max = 0, cnt = 1;
		alpha[str[0] - 'a'] = 1;
		int left = 0, right = 1, len = 1;
		while (right < str.length) {
			if (cnt <= n) {
				if (++alpha[str[right] - 'a'] == 1) 
					cnt++;
				
				right++; len++;
			}
			if (cnt > n) {
				if (--alpha[str[left] - 'a'] == 0) 
					cnt--;
				
				left++; len--;
			}
			
			max = Math.max(max, len);
		}

		System.out.println(max);
	}

}
