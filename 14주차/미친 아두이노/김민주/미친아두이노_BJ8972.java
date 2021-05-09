package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미친아두이노_BJ8972 {

	static int R, C;
	static int[][] count;
	static int r1, s1;
	static Queue<int[]> q;
	static int [] dx = {0, 1, 1, 1, 0, 0, 0, -1, -1, -1};
	static int [] dy = {0, -1, 0, 1, -1, 0, 1, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		q = new LinkedList<int[]>();
		for(int i = 0; i<R; i++) {
			String str = in.readLine();
			for(int j = 0; j<C; j++) {
				char val = str.charAt(j);
				if(val == 'R') q.add(new int[]{i,j});
				else if(val == 'I') {
					r1 = i;
					s1 = j;
				}
			}
		}

		String str = in.readLine();
		for(int i = 0; i<str.length(); i++) {
			int num = str.charAt(i)-'0';
		 // 1. 먼저, 종수가 아두이노를 이동시킴
			r1 += dx[num];
			s1 += dy[num];
			if(!isCheck()) { //2. 종수의 아두이노가 미친 아두이노가 있는 칸으로 이동한 경우 게임 끝
				System.out.println("kraj " + (i+1));
				return;
			}
			arduinoMove(); //3. 미친 아두이노 8방 이동
			if(!isCheck()) { //4. 종수의 아두이노가 미친 아두이노가 있는 칸으로 이동한 경우 게임 끝
				System.out.println("kraj " + (i+1));
				return;
			}
			checkArduino(); // 5. 2개 이상의 미친 아두이노가 같은 칸에 있으면 폭발
		}
		for(int i = 0; i<R; i++) { 
			for(int j = 0; j<C; j++) {
				if(count[i][j] == 1) sb.append('R');
				else if(i == r1 && j == s1) sb.append('I');
				else sb.append('.');
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	public static void checkArduino() {
		int size = q.size();
		while(size-->0) {
			int [] node = q.poll();
			int x = node[0];
			int y = node[1];
			if(count[x][y] == 1) q.add(new int[] {x,y});
		}
	}
	
	public static void arduinoMove() {
		int size = q.size();
		count = new int[R][C];
		while(size-->0) {
			int [] node = q.poll();
			int x = node[0];
			int y = node[1];
			int min = 1000;
			
			int newX = 0, newY = 0;
			for(int d = 1; d<10; d++) {
				int di = x + dx[d];
				int dj = y + dy[d];
				if(di < 0 || dj < 0 || di >= R || dj >=C) continue;
				int distance = Math.abs(r1-di) + Math.abs(s1-dj); //거리가 가장 가까운 애로 갱신
				if(min > distance) {
					min = distance;
					newX = di;
					newY = dj;
				}
			}
			q.add(new int[] {newX, newY});
			count[newX][newY]++;
		}
	}
	
	public static boolean isCheck() {
		int size = q.size();
		while(size-->0) {
			int [] node = q.poll();
			if(node[0] == r1 && node[1] == s1)
				return false;
			else q.add(new int[] {node[0], node[1]});
		}
		return true;
	}
	
}


