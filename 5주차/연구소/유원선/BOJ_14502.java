import java.io.*;
import java.util.*;

public class BOJ_14502 {

	static int n, m, res;
	static int[][] map;

	static int[] selected = new int[3];
	static List<int[]> empty = new ArrayList<>();
	static Queue<int[]> virus = new LinkedList<>();

	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        map = new int[n][m];
	
        for (int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j = 0; j < m; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        		if (map[i][j] == 0) empty.add(new int[] {i,j});
        		if (map[i][j] == 2) virus.add(new int[] {i,j});
        	}
        }
        
        combi(0, 0);
        System.out.println(res);
	}
	
	/*
	 * 바이러스 확산시키는 함수
	 */
	static void spreadVirus(int[][] MAP) {
		// 초기 바이러스 상태 복사해오기
		Queue<int[]> virusQueue = new LinkedList<>(virus);
		
		while (!virusQueue.isEmpty()) {
			int[] cur = virusQueue.poll();
			int x = cur[0], y = cur[1];
						
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
			
				if (nx < 0 || nx >= n || ny < 0 || ny >= m || MAP[nx][ny] != 0) continue;
				
				virusQueue.add(new int[] {nx,ny});
				MAP[nx][ny] = 2;
			}
		}
	}
	
	static int solve(int[] newWalls) {
		int cnt = 0;
		// 초기 map 상태 복사
		int[][] copyMap = new int[n][m];
		arrayCopy(map, copyMap);
		
		// 선택된 3곳 벽으로 처리하는 연산
		for (int i = 0; i < 3; i++) {
			int x = empty.get(newWalls[i])[0];
			int y = empty.get(newWalls[i])[1];
			copyMap[x][y] = 1;
		}
	
		spreadVirus(copyMap); // 바이러스 확산시키기
		
		// 안전 영역(0) 개수 구하기
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (copyMap[i][j] == 0) cnt++;
			}
		}

		return cnt;
	}
	
	/*
	 * 빈칸에서 벽으로 처리할 3개 위치 뽑아내기
	 */
	static void combi(int idx, int start) {
		if (idx == 3) {
			res = Math.max(res, solve(selected));
			return;
		}
		
		for (int i = start; i < empty.size(); i++) {
			selected[idx] = i;
			combi(idx + 1, i + 1);
		}
	}
	
	static void arrayCopy(int[][] A, int[][] B) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				B[i][j] = A[i][j];
			}
		}
	}
}