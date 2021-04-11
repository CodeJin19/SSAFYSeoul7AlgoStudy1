import java.io.*;
import java.util.*;

public class BOJ_2602 {

	static char[] arr, devil, angel;
	static int[][][] dp = new int[100][20][2];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = br.readLine().toCharArray();
		devil = br.readLine().toCharArray();
		angel = br.readLine().toCharArray();
		
		for (int[][] i : dp) 
			for (int[] row : i) 
				Arrays.fill(row, -1);
			
		int devil_start = go(0, 0, 0);
		int angel_start = go(0, 0, 1);
		
		System.out.println(devil_start + angel_start);
	}
	
	/*
	 * dp[현재 위치][찾아야 할 문자가 적힌 위치][악마/천사]	
	 */
	static int go(int cur, int find, int opt) {
		if (find == arr.length) return 1;
		if (dp[cur][find][opt] > -1) return dp[cur][find][opt];
		
		int val = 0;
		// 악마의 돌다리 탐색
		if (opt == 0) {
			for (int i = cur; i < devil.length; i++) {
				if (devil[i] == arr[find])
					val += go(i + 1, find + 1, 1); // 천사의 돌다리에서 찾으러 이동
			}
		}
		// 천사의 돌다리 탐색
		else {
			for (int i = cur; i < angel.length; i++) {
				if (angel[i] == arr[find])
					val += go(i + 1, find + 1, 0); // 악마의 돌다리에서 찾으러 이동
			}
		}
		
		return dp[cur][find][opt] = val;
	}

}
