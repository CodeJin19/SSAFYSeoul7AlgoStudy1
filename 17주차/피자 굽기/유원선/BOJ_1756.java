package com.ssafy.study;

import java.io.*;
import java.util.*;

public class BOJ_1756 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int d = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[d];
		st = new StringTokenizer(br.readLine());
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < d; i++) {
			int val = Integer.parseInt(st.nextToken());
			min = Math.min(min, val);
			arr[i] = min;
		}
		
		int left = 0, right = d;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int width = Integer.parseInt(st.nextToken());
			if (width > arr[0]) {
				System.out.println(0);
				return;
			}
			
			while (left < right) {
				int mid = (left + right) / 2;
				
				if (width <= arr[mid]) 
					left = mid + 1;
				else 
					right = mid;
			}
			
			left = 0; 
			right--;
		}
		
		System.out.println(right+1);
	}

}
