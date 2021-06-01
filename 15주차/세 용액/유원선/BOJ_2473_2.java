package com.ssafy.study;

import java.io.*;
import java.util.*;

public class BOJ_2473_2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		long[] arr = new long[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) 
			arr[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(arr);
		
		int s = 0, m = 0, e = 0; 
		long min = Long.MAX_VALUE; 
		for (int left = 0; left < n; left++) {
			int mid = left + 1;
			int right = n - 1;
			
			while (mid < right) {
				long sum = arr[left] + arr[mid] + arr[right];
				if (Math.abs(sum) < min) {
					min = Math.abs(sum);
					s = left;
					m = mid;
					e = right;
				}
				
				if (sum < 0) mid++;
				else right--;
			}
		}
		
		System.out.println(arr[s] + " " + arr[m] + " " + arr[e]);
	}
	
}
