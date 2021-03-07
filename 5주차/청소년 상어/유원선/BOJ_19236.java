import java.io.*;
import java.util.*;

public class BOJ_19236 {

	static int x, y, sharkDir, sum, max;
	static int[][] map = new int[4][4];
	static Fish[] fish = new Fish[17];
	
	static int[] dx = {0, -1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dy = {0, 0, -1, -1, -1, 0, 1, 1, 1};
	
	static class Fish {
		int x, y, dir;
		boolean live;
		
		Fish(int x, int y, int dir, boolean live) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.live = live;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        for (int i = 0; i < 4; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j = 0; j < 4; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        		int d = Integer.parseInt(st.nextToken());
        		fish[map[i][j]] = new Fish(i, j, d, true);
        	}
        }
    	
        int fishCnt = map[0][0];
        int dir = fish[fishCnt].dir;
        fish[fishCnt].live = false;
        map[0][0] = -1;
        
    	DFS(0, 0, dir, fishCnt);
    	
        System.out.println(max);
	}
	
	static void DFS(int x, int y, int sharkDir, int sum) {  
		
		max = Math.max(max, sum);
		int[][] copyMap = new int[4][4];
		Fish[] copyFish = new Fish[17];
		for (int i = 1; i <= 16; i++) {
			copyFish[i] = new Fish(0, 0, 0, true);
		}
		
		copyArray(map, copyMap, fish, copyFish);
		
		// 물고기 이동 처리
    	moveFish();
		
		for (int i = 1; i <= 3; i++) {
			int nx = x + dx[sharkDir] * i;
			int ny = y + dy[sharkDir] * i;
			
			if (nx >= 0 && nx < 4 && ny >= 0 && ny < 4) {
				if (map[nx][ny] == 0) continue;
				
				int fishCnt = map[nx][ny];
				int newDir = fish[fishCnt].dir;
				
				setState(x, y, nx, ny, fishCnt, true);
				DFS(nx, ny, newDir, sum + fishCnt);
				setState(x, y, nx, ny, fishCnt, false);
			}
			else break;
		}
		
		copyArray(copyMap, map, copyFish, fish);
	}
	
	static void setState(int x, int y, int nx, int ny, int cnt, Boolean state) {
		if (state) {
			map[x][y] = 0;
			map[nx][ny] = -1;
			fish[cnt].live = false;
		}
		else {
			map[x][y] = -1;
			map[nx][ny] = cnt;
			fish[cnt].live = true;
		}
	}
	
	static void moveFish() {
		for (int i = 1; i <= 16; i++) {
			if (!fish[i].live) continue;
			
			int fishX = fish[i].x;
			int fishY = fish[i].y;
			int d = fish[i].dir;
		
			int cnt = 0;
			while (true) {
				if (cnt == 8) break;
				
				int nx = fishX + dx[d];
				int ny = fishY + dy[d];
				
				if (nx < 0 || nx >= 4 || ny < 0 || ny >= 4 || map[nx][ny] == -1) {
					cnt++;
					d = (d + 1) % 9;
					if (d == 0) d = 1; 
					continue;
				}
				
				int tmp = map[nx][ny];
				map[nx][ny] = map[fishX][fishY];
				map[fishX][fishY] = tmp;
				
				fish[i].x = nx;
				fish[i].y = ny;
				fish[i].dir = d;
				
				if (tmp != 0) {
					fish[tmp].x = fishX;
					fish[tmp].y = fishY;
				}
				break;
			}
		}
	}
	
	static void copyArray(int[][] from1, int[][] to1, Fish[] from2, Fish[] to2) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				to1[i][j] = from1[i][j];
			}
		}
		for (int i = 1; i <= 16; i++) {
			to2[i].x = from2[i].x;
			to2[i].y = from2[i].y;
			to2[i].dir = from2[i].dir;
			to2[i].live = from2[i].live;
		}
	}
}