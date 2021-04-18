import java.io.*;
import java.util.*;

public class BOJ_9465 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			int[][] sticker = new int[2][n + 1];
			int[][] dp = new int[2][n + 1];
			
			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= n; j++)
					sticker[i][j] = Integer.parseInt(st.nextToken());
			}
			
			dp[0][1] = sticker[0][1];
			dp[1][1] = sticker[1][1];
			
			for (int j = 2; j <= n; j++) {
				for (int i = 0; i < 2; i++) {
					dp[i][j] = Math.max(dp[1 - i][j - 1], dp[1 - i][j - 2]) + sticker[i][j];
				}
			}
			
			System.out.println(Math.max(dp[0][n], dp[1][n]));
		}
	}

}