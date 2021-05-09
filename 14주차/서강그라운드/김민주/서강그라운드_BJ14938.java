package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 서강그라운드_BJ14938 {

	static int n, m, r;
	static int [] items;
	static int [][] distance;
	static final int INF = 9999999;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		items = new int[n+1];
		distance = new int[n+1][n+1];
		st = new StringTokenizer(in.readLine());
		for(int i = 1; i<=n; i++) {
			items[i] = Integer.parseInt(st.nextToken());
		}
		distance = new int[n+1][n+1];
		for(int i = 1; i<=n; i++) {
			Arrays.fill(distance[i], INF);
		}
		for(int i=1; i<=r; i++) {
			st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int dis = Integer.parseInt(st.nextToken());
			distance[from][to] = dis;
			distance[to][from] = dis;
		}
		for(int i = 1; i<=n; i++) {
			for(int j = 1; j<=n; j++) {
				System.out.print(distance[i][j]+" ");
			}
			System.out.println();
		}
		for(int k=1; k<=n; ++k) {
			for(int i=1; i<=n; i++) {
				if(i==k) continue; // 출발지와 경유지가 같다면 다음 출발지
				for(int j=1; j<=n; j++) {
					if(i==j || k==j) continue; // 경유지와 목적지가 같거나 출발지가 곧 목적지라면 패스
					if(distance[i][k]!= INF && distance[k][j] != INF && distance[i][j] > distance[i][k]+distance[k][j]) {
						distance[i][j] = distance[i][k]+distance[k][j];
					}
				}
			}
		}
		for(int i = 1; i<=n; i++) {
			for(int j = 1; j<=n; j++) {
				System.out.print(distance[i][j]+" ");
			}
			System.out.println();
		}
		int sum = 0;
	    for(int i = 1; i <= n; i++){
	        int val = items[i];
	        for(int j = 1; j <= n; j++){
	            if(distance[i][j] <= m && i != j){
	            	val += items[j];
	            }
	        }
	        sum = Math.max(sum, val);
	    }
	    System.out.println(sum);
	}
}
