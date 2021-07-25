package week22;

import java.io.*;
import java.util.*;

public class 신입사원_BJ1946 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader  in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int tc = 1; tc<=T; tc++) {
			int N = Integer.parseInt(in.readLine());
			int [] score = new int[N+1];
			for(int i = 0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				score[x] = y;
			}
			int miny = score[1];
			int cnt = 1;
			for(int i = 2; i<=N; i++) {
				// 면접성적이 더 낮을때만 갱신, cnt++
				if(miny > score[i]) {
					miny = score[i];
					++cnt;
				}
			}
			System.out.println(cnt);
		}
	}

}
