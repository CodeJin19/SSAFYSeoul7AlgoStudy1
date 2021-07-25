package week22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 램프_BJ1034 {

	static int N, M, K, result, max = 0;
	static int [][] lamp;
	static boolean [] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		lamp = new int[N][M];
		visit = new boolean[N];
		for(int i = 0; i<N; i++) {
			String str = in.readLine();
			for(int j = 0; j<M; j++) {
				lamp[i][j] = str.charAt(j)-'0';
			}
		}
		K = Integer.parseInt(in.readLine());
		canOrNot();
		System.out.println(max);
	}
	
	public static void canOrNot() {
		for(int i = 0; i<N; i++) {
			if(visit[i]) continue;
			int cnt = 0;
			for(int j = 0; j<M; j++) {
				if(lamp[i][j] == 0) cnt++;
			}
			if(cnt <=K && cnt%2==K%2) {
				nextCheck(i);
			}
		}
	}
	
	public static void nextCheck(int row) {
		int count = 1;
		for(int i = row+1; i<N; i++) {
			boolean flag = true;
			for(int j = 0; j<M; j++) {
				if(lamp[row][j] != lamp[i][j]) {
					flag = false;
					break;
				}
			}
			if(flag) {
				++count;
				visit[i] = true;
			}
		}
		
		max = Math.max(max, count);
	}
}
