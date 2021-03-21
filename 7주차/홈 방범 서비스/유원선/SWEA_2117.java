package com.ssafy.study;

import java.io.*;
import java.util.*;

public class SWEA_2117 {
	
	static int n, m, max_k;
	static int[][] board;
	static boolean[][] visited;
	static Queue<Node> q = new LinkedList<>();
	
	static class Node {
		int x, y;
		
		Node (int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= T; t++) {
        	st = new StringTokenizer(br.readLine());
        	n = Integer.parseInt(st.nextToken());
        	m = Integer.parseInt(st.nextToken());
        	
        	board = new int[n][n];
        	
        	int max_home = 0;
        	for (int i = 0; i < n; i++) {
        		st = new StringTokenizer(br.readLine());
        		for (int j = 0; j < n; j++) {
        			board[i][j] = Integer.parseInt(st.nextToken());
        			if (board[i][j] == 1) {
        				max_home++;
        			}
        		}
        	}
        	
        	// 최대로 가능한 k를 구하기 위함
        	int max_profit = max_home * m;
        	int idx = 1, cost = 0;
        	while (true) {
        		cost = idx * idx + (idx - 1) * (idx - 1);
        		if (cost > max_profit) {
        			idx--;
        			break;
        		}
        		idx++;
        	}
        	max_k = idx;
        	
        	int res = 0;
        	for (int i = 0; i < n; i++) {
        		for (int j = 0; j < n; j++) {
        			q.clear();
            		visited = new boolean[n][n];
            		
            		q.add(new Node(i, j));
            		visited[i][j] = true;
            		
            		res = Math.max(res, BFS());
        		}
        	}
     
        	System.out.println("#" + t + " " + res);
        }
	}
	
	static int BFS() {
		int max = 0, cnt = 0;
		
		for (int i = 1; i <= max_k; i++) {
			int q_size = q.size();
			for (int j = 0; j < q_size; j++) {
				Node cur = q.poll();
				if (board[cur.x][cur.y] == 1)
					cnt++;
				
				for (int k = 0; k < 4; k++) {
					int nx = cur.x + dx[k];
					int ny = cur.y + dy[k];
					
					if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny]) continue;
					
					q.add(new Node(nx, ny));
					visited[nx][ny] = true;
				}
			}
			int cost = i * i + (i - 1) * (i - 1);
			if (cnt * m >= cost) 
				max = Math.max(max, cnt);
		}
		
		return max;
	}
}