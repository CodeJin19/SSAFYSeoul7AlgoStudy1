package com.ssafy.study;

import java.io.*;
import java.util.*;

public class SWEA_4008 {
	
	static int n, max, min;
	static int[] optNum, number;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= T; t++) {
        	n = Integer.parseInt(br.readLine());
        	
        	optNum = new int[4];
        	number = new int[n];
        	
        	max = Integer.MIN_VALUE;
        	min = Integer.MAX_VALUE;
        	
        	st = new StringTokenizer(br.readLine());
        	for (int i = 0; i < 4; i++)
        		optNum[i] = Integer.parseInt(st.nextToken());
        	
        	st = new StringTokenizer(br.readLine());
        	for (int i = 0; i < n; i++)
        		number[i] = Integer.parseInt(st.nextToken());
        	
        	DFS(0, number[0]);
        	System.out.println("#" + t + " " + (max - min));
        }
	}
	
	static void DFS(int idx, int num) {
		if (idx == n - 1) {
			min = Math.min(min, num);
			max = Math.max(max, num);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			if (optNum[i] != 0) {
				optNum[i]--;
				DFS(idx + 1, calculate(num, number[idx + 1], i));
				optNum[i]++;
			}
		}	
	}
	
	static int calculate(int num, int nextNum, int which) {
		switch(which) {
		case 0:
			return num + nextNum;
		case 1:
			return num - nextNum;
		case 2:
			return num * nextNum;
		case 3:
			return num / nextNum;
		}
		return 0;
	}

}
