package com.ssafy.baekjoon;

import java.io.*;
import java.util.*;

public class 이모티콘_BJ14226 {

	static class Emo {
		int screen, clip, time;

		public Emo(int screen, int clip, int time) {
			super();
			this.screen = screen;
			this.clip = clip;
			this.time = time;
		}

	}

	static int S;
	static Queue<Emo> q;
	static boolean visited[][] = new boolean[1001][1001];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		S = Integer.parseInt(in.readLine());
		q = new LinkedList<Emo>();
		// 최초 화면 1개
		q.offer(new Emo(1, 0, 0));
		visited[1][0] = true;

		System.out.println(bfs());
	}

	public static int bfs() {
		while (!q.isEmpty()) {

			Emo e = q.poll();
			int screen = e.screen;
			int clip = e.clip;
			int time = e.time;
			//System.out.println(screen);
			if (screen == S) {
				return time;
			}
			if (screen > 0 && screen < 1001) {
				// 1. 화면에 있는 이모티콘을 모두 복사해서 클립보드에 저장한다. 
				if (!visited[screen][screen]) {
					visited[screen][screen] = true;
					q.offer(new Emo(screen, screen, time + 1));
				}
				// 2. 클립보드에 있는 모든 이모티콘을 화면에 붙여넣기 한다. => 클립보드가 비어있으면 안됨
				if (clip > 0 && screen + clip < 1001) {
					if (!visited[screen + clip][clip]) {
						visited[screen + clip][clip] = true;
						q.offer(new Emo(screen + clip, clip, time + 1));
					}
				}
				// 3. 화면에 있는 이모티콘 중 하나를 삭제한다.
				if (!visited[screen - 1][clip]) {
					q.offer(new Emo(screen - 1, clip, time + 1));
					visited[screen - 1][clip] = true;
				}
			}

		}
		return 0;
	}
}
