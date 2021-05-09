package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 택배_BJ8980 {

	static class Node implements Comparable<Node>{
		int from, to, num;

		public Node(int from, int to, int num) {
			super();
			this.from = from;
			this.to = to;
			this.num = num;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Node [from=").append(from).append(", to=").append(to).append(", num=").append(num)
					.append("]");
			
			
			return builder.toString();
		}

		@Override
		public int compareTo(Node o) {
			if(this.to < o.to) {
				return -1;
			}
			else if(this.to == o.to) {
				if(this.from < o.from)
					return -1;
			}
			return 1;
//			if(this.to == o.to) {
//				return this.from-o.from;
//			}
//			return this.to-o.to;
		}
	}
	
	static int N, C, M, result;
	static ArrayList<Node> info;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(in.readLine());
		info = new ArrayList<Node>();
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			info.add(new Node(from, to, num));
		}
		Collections.sort(info);
		delivery();
		System.out.println(result);
		
	}
	
	private static void delivery() {
		int min = Integer.MAX_VALUE;
		int cnt[] = new int[N+1];
		for(int i = 0; i<M; i++) {
			Node now = info.get(i);
			int from = now.from;
			int to = now.to;
			int num = now.num;
			int get = 0;
			
			for(int j = from; j<to; j++) {
				get = Math.max(get, cnt[j]);
			}
			
			get = Math.min(C-get, num);
			result += get;
			
			for(int j = from; j<to; j++) {
				cnt[j] += get;
			}
			
		}
	}
}

/*
4 40
6
3 4 20
1 2 10
2 3 10
1 4 30
1 3 20
2 4 20
*/