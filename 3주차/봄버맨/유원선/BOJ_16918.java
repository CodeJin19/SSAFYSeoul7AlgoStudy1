import java.io.*;
import java.util.*;

public class BOJ_16918 {
	
	static int[] dx = {0, -1, 0, 1, 0};
    static int[] dy = {0, 0, 1, 0, -1};
	static int r, c, n;

	static char[][] board, bombInfo;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        
        board = new char[r][c];
        bombInfo = new char[r][c];
        for (int i = 0; i < r; i++)
        	board[i] = br.readLine().toCharArray();
        copyArray(); // 폭탄 정보 저장
        
        int time = 1; 
        while (true) {
        	if (time == n) break;
        	
        	time++;
        	
        	if (time % 2 == 0) setBomb();
        	else removeBomb();
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < r; i++) {
        	for (int j = 0; j < c; j++)
        		sb.append(board[i][j]);
        	sb.append('\n');
        }
        
        System.out.println(sb);
	}
	
	static void setBomb() {
		for (char[] row : board)
			Arrays.fill(row, 'O');
	}
	
	static void removeBomb() {
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (bombInfo[i][j] == 'O') {
					for (int k = 0; k < 5; k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];
						if (nx < 0 || nx >= r || ny < 0 || ny >= c || board[nx][ny] == '.') continue;
						
						board[nx][ny] = '.';
					}
				}
			}
		}
		
		copyArray(); // 새로운 폭탄 정보 저장
	}
	
	static void copyArray() {
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++)
				bombInfo[i][j] = board[i][j];
		}
	}
}