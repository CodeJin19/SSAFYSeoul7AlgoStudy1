import java.io.*;
import java.util.*;

public class BOJ_6987 {
	
	static final int MATCH_CNT = 15;
	static final int TEAM_CNT = 6;
	
	static int[][] result;
	static int[][] match;
	
	static boolean finished = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for (int t = 0; t < 4; t++) {
			result = new int[TEAM_CNT][3];
			match = new int[MATCH_CNT][2];
			
			finished = false;
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 18; i++) 
				result[i/3][i%3] = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < TEAM_CNT; i++) {
				int sum = 0;
				for (int j = 0; j < 3; j++)
					sum += result[i][j];
				
				if (sum != 5) {
					finished = true;
					break;
				}
			}
			
			if (finished) {
				sb.append(0).append(" ");
				continue;
			}
			
			int idx = 0;
			for (int i = 0; i < TEAM_CNT; i++) {
				for (int j = i + 1; j < TEAM_CNT; j++) {
					match[idx][0] = i;
					match[idx++][1] = j;
				}
			}
			
			DFS(0);
			if (finished) sb.append(1).append(" ");
			else sb.append(0).append(" ");
		}
		
		System.out.println(sb);
	}
	
	static void DFS(int idx) {
		if (idx == MATCH_CNT) {
			finished = true;
			return;
		}
		
		int a = match[idx][0], b = match[idx][1];
		// a 승 - b 패
		if (result[a][0] > 0 && result[b][2] > 0) {
			result[a][0]--;
			result[b][2]--;
			DFS(idx + 1);
			result[a][0]++;
			result[b][2]++;
		}
		
		// a 무 - b 무	
		if (result[a][1] > 0 && result[b][1] > 0) {
			result[a][1]--;
			result[b][1]--;
			DFS(idx + 1);
			result[a][1]++;
			result[b][1]++;
		}
		
		// a 패 - b 승
		if (result[a][2] > 0 && result[b][0] > 0) {
			result[a][2]--;
			result[b][0]--;
			DFS(idx + 1);
			result[a][2]++;
			result[b][0]++;
		}			
	}

}