package com.ssafy.study;

import java.io.*;
import java.util.*;

public class BOJ_15787 {
	
	static int n, m;
	static boolean[][] train;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Set<String> trains = new HashSet<>();
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        train = new boolean[n + 1][21];
        
        for (int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine());
        	int opt = Integer.parseInt(st.nextToken());
        	int t = Integer.parseInt(st.nextToken());
        	int x = 0;
        	if (opt < 3) {
        		x = Integer.parseInt(st.nextToken());
        	}
        	
        	solve(opt, t, x);
        }
        
        for (int i = 1; i <= n; i++) {
        	String tmp = "";
        	for (int j = 1; j <= 20; j++) 
        		tmp += (train[i][j] ? "1" : "0");
        	
        	trains.add(tmp);
        }
        
        System.out.println(trains.size());   
	}
	
	static void solve(int opt, int t, int x) {
		switch(opt) {
		case 1:
			if (!train[t][x]) train[t][x] = true;
			break;
		case 2:
			if (train[t][x]) train[t][x] = false;
			break;
		case 3:
			for (int i = 20; i > 1; i--) 
				train[t][i] = train[t][i - 1];
			
			train[t][1] = false;
			break;
		case 4:
			for (int i = 1; i < 20; i++) 
				train[t][i] = train[t][i + 1];
			
			train[t][20] = false;
			break;
		}
	}

}
