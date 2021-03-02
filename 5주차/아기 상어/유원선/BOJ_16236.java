import java.io.*;
import java.util.*;

public class BOJ_16236 {
	
	static int n, time, shark = 2, eat;
	static int[][] map;
	static boolean[][] visited;
	
	static PriorityQueue<Shark> pq = new PriorityQueue<>(new Comparator<Shark>() {

		@Override
		public int compare(Shark s1, Shark s2) {
			if (s1.cnt == s2.cnt) {
				if (s1.x == s2.x)
					return s1.y - s2.y;
				else 
					return s1.x - s2.x;
			}
			else
				return s1.cnt - s2.cnt;
		}
		
	}); // 거리가 같은 물고기들을 처리하기 위한 우선순위 큐
	
	static int[] dx = {-1, 0, 0, 1};
	static int[] dy = {0, -1, 1, 0};
	
	static class Shark {
		int x, y, cnt;
		
		Shark(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];
        
        for (int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j = 0; j < n; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        		if (map[i][j] == 9) {
        			map[i][j] = 0;
        			pq.add(new Shark (i,j,0));
        		}
        	}
        }
        
        System.out.println(searchFish());
	}
	
	static int searchFish() {
		while (!pq.isEmpty()) {
			Shark cur = pq.poll();
			int x = cur.x, y = cur.y, cnt = cur.cnt;
			
			// 상어 크기보다 작은 물고기를 만났다면
			if (map[x][y] != 0 && map[x][y] < shark) {
				eat++; // 먹은 수 증가
				map[x][y] = 0; // 먹은 물고기 빈칸 처리
				
				// 상어 크기 수만큼 물고기를 먹으면 상어 크기 1 증가, 먹은 수 0으로 초기화
				if (eat == shark) {
					shark++;
					eat = 0;
				}
				
				visited = new boolean[n][n];
				pq.clear(); // 큐 비우기
				
				time = cnt; // 이동 시간 갱신
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				// 범위를 벗어나거나, 방문했거나, 물고기의 크기가 상어보다 크면 제외
				if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny] || map[nx][ny] > shark) continue;
				
				pq.add(new Shark (nx,ny,cnt + 1));
				visited[nx][ny] = true;
			}
		}
		
		return time;
	}

}