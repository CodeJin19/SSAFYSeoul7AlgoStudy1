import java.io.*;
import java.util.*;

public class BOJ_16954 {

	static char[][] miro = new char[8][8];
	static Queue<int[]> person = new LinkedList<>();
	static PriorityQueue<int[]> walls = new PriorityQueue<>((w1, w2) -> w2[0] - w1[0]);
	
	static int[] dx = {0, -1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dy = {0, 0, 1, 1, 1, 0, -1, -1, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        for (int i = 0; i < 8; i++) {
        	String tmp = br.readLine();
        	for (int j = 0; j < 8; j++) {
        		miro[i][j] = tmp.charAt(j);
        		if (miro[i][j] == '#') walls.add(new int[] {i,j});
        	}
        }
        
        miro[7][0] = 'P';
        person.add(new int[] {7,0});
        
        solve();
	}
	
	static int movePerson() {
		boolean isPossible = false;
		int size = person.size();
		
		for (int i = 0; i < size; i++) {
			int[] cur = person.poll();
			int x = cur[0], y = cur[1];
			
			// 사람이 있던 칸이 벽으로 바뀌어 있다면 제외
			if (miro[x][y] == '#') continue;
			miro[x][y] = '.'; // 빈칸 처리
			
			// 목적지에 도착하면 1 리턴
			if (x == 0 && y == 7)
				return 1;
			
			for (int j = 0; j < 9; j++) {
				int nx = x + dx[j];
				int ny = y + dy[j];
				
				if (nx < 0 || nx >= 8 || ny < 0 || ny >= 8) continue;
				if (miro[nx][ny] == '.') {
					isPossible = true;
					person.add(new int[] {nx,ny});
					miro[nx][ny] = 'P';
				}
			}
		}
		
		// 한 번도 이동을 못하면 0 리턴
		if (!isPossible)
			return 0;
		
		// 목적지에 아직 도착하지 않고 이동했으면 2 리턴
		return 2;
	}
	
	static void moveWall() {
		int sizeOfWall = walls.size();
		List<int[]> tmp = new ArrayList<>();
		for (int i = 0; i < sizeOfWall; i++) {
			int[] cur = walls.poll();
			int x = cur[0], y = cur[1];

			miro[x][y] = '.';
			if (x != 7) {
				miro[x + 1][y] = '#';
				tmp.add(new int[] {x + 1,y});
			}	
		}
		for (int[] w : tmp) walls.add(new int[] {w[0],w[1]});
	}
	
	static void solve() {
		while (true) {
			// 사람 이동시키기
			int val = movePerson();
			if (val != 2) {
				System.out.println(val);
				return;
			}
			
			// 벽 내리기
			moveWall();
		}
	}
}