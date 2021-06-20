package com.ssafy.study;

import java.io.*;
import java.util.*;

public class BOJ_14226 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int s = Integer.parseInt(br.readLine());
		
		int[][] visited = new int[s+1][s+1];
		for (int[] row : visited) Arrays.fill(row, -1);
		Queue<int[]> q = new LinkedList<>();

		q.add(new int[] {1,0});
		visited[1][0] = 0;
	
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int screen = cur[0], board = cur[1];
			
			if (screen == s) {
				System.out.println(visited[screen][board]);
				break;
			}
			
			if (screen+board <= s && visited[screen+board][board] == -1) {
				q.add(new int[] {screen+board, board});
				visited[screen+board][board] = visited[screen][board] + 1;
			}
			if (visited[screen][screen] == -1) {
				q.add(new int[] {screen, screen});
				visited[screen][screen] = visited[screen][board] + 1;
			}
			if (screen > 0 && visited[screen-1][board] == -1) {
				q.add(new int[] {screen-1, board});
				visited[screen-1][board] = visited[screen][board] + 1;
			}
		}
	}

}
