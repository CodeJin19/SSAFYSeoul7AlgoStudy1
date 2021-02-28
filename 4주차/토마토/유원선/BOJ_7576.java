import java.io.*;
import java.util.*;

public class BOJ_7576 {

	static int n, m, cnt;
	static int[][] tomato;
	static Queue<int[]> q = new LinkedList<>();
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		tomato = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				tomato[i][j] = Integer.parseInt(st.nextToken());
				if (tomato[i][j] == 1)
					q.add(new int[] {i, j, 0});
			}
		}
		
		BFS();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (tomato[i][j] == 0) {
					System.out.println(-1);
					return;
				}
			}
		}
		
		System.out.println(cnt);
	}
	
	static void BFS() {
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			
			cnt = cur[2];
			
			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				
				if (nx < 0 || nx >= n || ny < 0 || ny >= m || tomato[nx][ny] != 0) continue;
				
				tomato[nx][ny] = 1;
				q.add(new int[] {nx, ny, cur[2] + 1});
			}
			
		}
	}
}