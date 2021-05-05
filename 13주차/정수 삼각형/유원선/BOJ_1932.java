package com.ssafy.study;

import java.io.*;
import java.util.*;

public class BOJ_1932 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
                
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n+1][n+1];
        int res = 0;
                
        for (int i = 1; i <= n; i++) {
        	st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= i; j++) {
            	dp[i][j] = Integer.parseInt(st.nextToken()) + Math.max(dp[i-1][j-1], dp[i-1][j]);
            	res = Math.max(res, dp[i][j]);
            }
        }
                
        System.out.println(res);
	}
	
}
