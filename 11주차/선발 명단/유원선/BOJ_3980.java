import java.io.*;
import java.util.*;

public class BOJ_3980 {

	static int res;
	static int[][] board;
	static boolean[] visited;
	static int[] selected;
	static List<Integer>[] list;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			board = new int[11][11];
			visited = new boolean[11];
			selected = new int[11];
			list = new ArrayList[11];
			for (int i = 0; i < 11; i++)
				list[i] = new ArrayList<>();
			
			res = 0;
			
			for (int i = 0; i < 11; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 11; j++)
					board[i][j] = Integer.parseInt(st.nextToken());
			}
			
			for (int j = 0; j < 11; j++) {
				for (int i = 0; i < 11; i++) {
					if (board[i][j] > 0)
						list[j].add(i);
				}
			}
			
			solve(0);
			System.out.println(res);
		}

	}
	
	static void solve(int idx) {
		if (idx == 11) {
			int sum = 0;
			for (int i = 0; i < 11; i++) 
				sum += board[selected[i]][i];
			
			res = Math.max(res, sum);
			
			return;
		}
		
		for (int i = 0; i < list[idx].size(); i++) {
			int player = list[idx].get(i);
			
			if (!visited[player]) {
				visited[player] = true;
				selected[idx] = player;
				solve(idx + 1);
				visited[player] = false;
			}
		}
	}

}