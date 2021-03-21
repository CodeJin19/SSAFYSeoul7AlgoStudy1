package com.ssafy.study;

import java.io.*;
import java.util.*;

public class SWEA_5644 {
	
	static int m, a, sum;
	static int[] move_a, move_b;
	static BC[] bc;
	
	static List<Integer> BC_a, BC_b;
	
	static int[] dx = {0, 0, 1, 0, -1};
	static int[] dy = {0, -1, 0, 1, 0};
	
	static class BC {
		int x, y, cover, p;
		
		BC (int x, int y, int cover, int p) {
			this.x = x;
			this.y = y;
			this.cover = cover;
			this.p = p;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= T; t++) {
        	st = new StringTokenizer(br.readLine());
        	m = Integer.parseInt(st.nextToken());
        	a = Integer.parseInt(st.nextToken());
        	
        	sum = 0;
        	
        	move_a = new int[m+1];
        	move_b = new int[m+1];
        	st = new StringTokenizer(br.readLine());
        	for (int i = 1; i <= m; i++) move_a[i] = Integer.parseInt(st.nextToken());
        	st = new StringTokenizer(br.readLine());
        	for (int i = 1; i <= m; i++) move_b[i] = Integer.parseInt(st.nextToken());
        	
        	bc = new BC[a];
        	for (int i = 0; i < a; i++) {
        		st = new StringTokenizer(br.readLine());
        		int x = Integer.parseInt(st.nextToken());
        		int y = Integer.parseInt(st.nextToken());
        		int cover = Integer.parseInt(st.nextToken());
        		int p = Integer.parseInt(st.nextToken());
        		bc[i] = new BC(x, y, cover, p);
        	}
        	
        	int ax = 1, ay = 1, bx = 10, by = 10;
        	for (int i = 0; i <= m; i++) {
        		int nax = ax + dx[move_a[i]]; int nay = ay + dy[move_a[i]];
        		int nbx = bx + dx[move_b[i]]; int nby = by + dy[move_b[i]];
        		
        		BC_a = new ArrayList<>();
        		BC_b = new ArrayList<>();
        		
        		searchBC(nax, nay, BC_a);
        		searchBC(nbx, nby, BC_b);
        		
        		sum += decideBC();
        		
        		ax = nax; ay = nay;
        		bx = nbx; by = nby;
        	}
        	
        	System.out.println("#" + t + " " + sum);	
        }
	}
	
	static int decideBC() {
		int max = 0;
		
		if (BC_a.isEmpty() && BC_b.isEmpty()) return 0;
		else if (BC_a.isEmpty() && !BC_b.isEmpty()) {
			for (int idx_b : BC_b) 
				max = Math.max(max, bc[idx_b].p);
			
			return max;
		}
		else if (!BC_a.isEmpty() && BC_b.isEmpty()) {
			for (int idx_a : BC_a) 
				max = Math.max(max, bc[idx_a].p);
			
			return max;
		}
		else {
			int cur = 0;
			for (int idx_a : BC_a) {
				for (int idx_b : BC_b) {
					if (idx_a == idx_b) cur = bc[idx_a].p;
					else cur = bc[idx_a].p + bc[idx_b].p;
					max = Math.max(max, cur);
				}
			}
			
			return max;
		}
	}
	
	static void searchBC(int x, int y, List<Integer> bcs) {
		for (int i = 0; i < a; i++) {
			int dis = Math.abs(x - bc[i].x) + Math.abs(y - bc[i].y);
			
			if (dis <= bc[i].cover) 
				bcs.add(i);
		}
	}
}
