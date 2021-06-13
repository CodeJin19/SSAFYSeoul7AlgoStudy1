package com.ssafy.algoStudy_13;

import java.io.*;
import java.util.*;

public class BJ_13549 {
	static class Node implements Comparable<Node> {
		int pos;
		int time;

		public Node(int pos, int time) {
			super();
			this.pos = pos;
			this.time = time;
		}

		@Override
		public int compareTo(Node o) {
			if (this.time < o.time)
				return -1;
			else
				return 1;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		PriorityQueue<Node> queue = new PriorityQueue<Node>();
		int time = Integer.MAX_VALUE;
		boolean cache[] = new boolean[200001];

		if (n == k) {
			System.out.println(0);
		} else {
			queue.offer(new Node(n, 0));
			cache[n] = true;

			while (!queue.isEmpty()) {
				Node now = queue.poll();

				if (time < now.time) {
					continue;
				}

				if (now.pos == k) {
					time = Math.min(time, now.time);
				}

				if (0 <= now.pos - 1 && now.pos - 1 < 200000 && !cache[now.pos - 1]) {
					cache[now.pos - 1] = true;
					queue.offer(new Node(now.pos - 1, now.time + 1));
				}

				if (0 <= now.pos + 1 && now.pos + 1 < 200000 && !cache[now.pos + 1]) {
					cache[now.pos + 1] = true;
					queue.offer(new Node(now.pos + 1, now.time + 1));
				}

				if (0 <= now.pos * 2 && now.pos * 2 < 200000 && !cache[now.pos * 2]) {
					cache[now.pos * 2] = true;
					queue.offer(new Node(now.pos * 2, now.time));
				}
			}

			System.out.println(time);
		}
	}
}
