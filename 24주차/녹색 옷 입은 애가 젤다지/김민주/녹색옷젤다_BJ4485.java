package week24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 녹색옷젤다_BJ4485 {

	static class Node implements Comparable<Node>{
		int x, y, val;

		public Node(int x, int y, int val) {
			super();
			this.x = x;
			this.y = y;
			this.val = val;
		}

		@Override
		public int compareTo(Node o) {
			return this.val-o.val;
		}
	}
	
	static int N, min = Integer.MAX_VALUE;
	static int [][] map;
	static int [] dx = {-1, 1, 0, 0};
	static int [] dy = {0, 0, -1, 1};
	static PriorityQueue<Node> pq = new PriorityQueue<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = 1;
		while(true) {
			
			N = Integer.parseInt(in.readLine());
			if(N == 0) break;
			
			map = new int[N][N];
			int [][] ans = new int[N][N];
			for(int i = 0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				for(int j = 0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					ans[i][j] = Integer.MAX_VALUE;
				}
			}
			pq.add(new Node(0, 0, map[0][0]));
			
			while(!pq.isEmpty()) {
				Node node = pq.poll();
				int x = node.x;
				int y = node.y;
				int val = node.val;
				
				for(int d = 0; d<4; d++) {
					int di = x + dx[d];
					int dj = y + dy[d];
					if(di < 0 || dj < 0 || di >= N || dj >= N) continue;
					if(ans[di][dj] > map[di][dj] + val) {
						ans[di][dj] = map[di][dj] + val;
						pq.add(new Node(di, dj, ans[di][dj]));
					}
				}
			}
			
			sb.append("Problem ").append(tc++).append(": ").append(ans[N-1][N-1]).append("\n");
		}
		System.out.println(sb);
	}

}
