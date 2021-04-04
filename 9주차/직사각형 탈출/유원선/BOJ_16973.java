import java.io.*;
import java.util.*;

public class BOJ_16973 {
	
	static int n, m, h, w, toX, toY;
	static int[][] board;
	static boolean[][] visited;

	static Queue<int[]> q = new LinkedList<>();
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		board = new int[n+1][m+1];
		visited = new boolean[n+1][m+1];
		
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= m; j++)
				board[i][j] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		h = Integer.parseInt(st.nextToken()); w = Integer.parseInt(st.nextToken());
		int a = Integer.parseInt(st.nextToken()); int b = Integer.parseInt(st.nextToken());
		toX = Integer.parseInt(st.nextToken()); toY = Integer.parseInt(st.nextToken());
		
		q.add(new int[] {a,b,0});
		visited[a][b] = true;
		
		System.out.println(BFS());
	}
	
	static int BFS() {
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0], y = cur[1], cnt = cur[2];
			
			if (x == toX && y == toY) 
				return cnt;
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i], ny = y + dy[i];
				
				if (nx < 1 || nx+h-1 > n || ny < 1 || ny+w-1 > m || visited[nx][ny]) continue;
				if (isPossible(nx, ny, i)) {
					q.add(new int[] {nx, ny, cnt + 1});
					visited[nx][ny] = true;	
				}
			}
		}
		
		return -1;
	}
	
	static boolean isPossible(int x, int y, int dir) {
		if (dir == 0) {
			for (int i = y; i < y + w; i++) {
				if (board[x][i] == 1) return false;
			}
		}
		else if (dir == 1) {
			int ny = y + w - 1;
			if (ny > m) return false;
			for (int i = x; i < x + h; i++) {
				if (board[i][ny] == 1) return false;
			}
		}
		else if (dir == 2) {
			int nx = x + h - 1;
			if (nx > n) return false;
			for (int i = y; i < y + w; i++) {
				if (board[nx][i] == 1) return false;
			}
		}
		else {
			for (int i = x; i < x + h; i++) {
				if (board[i][y] == 1) return false;
			}
		}
		
		return true;
	}

}