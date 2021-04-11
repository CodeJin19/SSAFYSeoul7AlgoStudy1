import java.io.*;
import java.util.*;

public class BOJ_1495 {

	static int n, s, m;
	static int[] volume;
	static int[][] cache;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		cache = new int[n + 1][1001];
		volume = new int[n + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			volume[i] = Integer.parseInt(st.nextToken());
		
		for (int[] row : cache) Arrays.fill(row,  -1);
		
		int res = DFS(s, 0);
		
		if (res == -2) System.out.println(-1);
		else System.out.println(res);
	}
	
	static int DFS(int vol, int idx) {
		if (vol < 0 || vol > m) return -2;
		if (idx == n) return cache[idx][vol] = vol;
		if (cache[idx][vol] != -1) return cache[idx][vol];
	
		return cache[idx][vol] = Math.max(DFS(vol + volume[idx], idx + 1), DFS(vol - volume[idx], idx + 1));
	}

}