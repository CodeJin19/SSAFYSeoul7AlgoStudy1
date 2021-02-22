import java.io.*;
import java.util.*;

public class BOJ_2206 {

	static int n, m;
	static char[][] map;
	static boolean[][][] visited;
	static Queue<Info> q = new LinkedList<>();
	
	static class Info {
		int x, y, wall, cnt;
		
		// x 좌표, y 좌표, 벽 부심 체크(0, 1), 이동 수
		Info(int x, int y, int wall, int cnt) {
			this.x = x;
			this.y = y;
			this.wall = wall;
			this.cnt = cnt;
		}
	}
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        visited = new boolean[n][m][2]; // x좌표, y좌표, 벽이 부서졌는지 체크(0: map[n][m] 위치까지 왔을 때 한번도 안부심, 1: map[n][m] 위치까지 왔을 때 1번 부심)
        
        for (int i = 0; i < n; i++) map[i] = br.readLine().toCharArray();
        
        System.out.println(BFS());
	}
	
	static int BFS() {
		q.add(new Info(0, 0, 0, 1));
		visited[0][0][0] = true;
		
		while (!q.isEmpty()) {
			Info cur = q.poll();
			
			if (cur.x == n - 1 && cur.y == m - 1) 
				return cur.cnt;
			
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny][cur.wall]) continue;
				
				// 벽을 만났는 데 아직 안 부셨다면
				if (map[nx][ny] == '1' && cur.wall == 0) {
					q.add(new Info(nx, ny, cur.wall + 1, cur.cnt + 1));
					visited[nx][ny][cur.wall + 1] = true;
				}
				if (map[nx][ny] == '0') {
					q.add(new Info(nx, ny, cur.wall, cur.cnt + 1));
					visited[nx][ny][cur.wall] = true;
				}
			}
		}
		
		return -1;
	}
}