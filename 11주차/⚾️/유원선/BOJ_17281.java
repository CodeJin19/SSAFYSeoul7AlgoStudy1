import java.io.*;
import java.util.*;

public class BOJ_17281 {
	
	static int n, ans;
	static int[] order = new int[10]; // 타순을 저장하는 배열
	static int[][] record; // 각 이닝 당 1~9번 타자의 결과
	static boolean[] visited = new boolean[10]; // 순열 방문 체크
	static boolean[] base = new boolean[4]; // 주자 진루 상황

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        record = new int[n + 1][10];
        for (int i = 1; i <= n; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j = 1; j <= 9; j++) 
        		record[i][j] = Integer.parseInt(st.nextToken());
        }
        order[4] = 1; // 4번 타자는 1번으로 고정
        Permu(1);
        
        System.out.println(ans);
	}
	
	static int simulation() {
		int batterIdx = 1, score = 0;
		for (int i = 1; i <= n; i++) {	
			int outCnt = 0; // out 초기화
			Arrays.fill(base, false); // 주자 상황 초기화
			
			while (true) {				
				int val = record[i][order[batterIdx]];
				
				// 아웃이면 카운트 증가
				if (val == 0) outCnt++;
				else {
					// 3루부터 주자들을 관리
					for (int j = 3; j >= 1; j--) {
						int nextB = j + val;
						// 해당 베이스에 주자가 있으면
						if (base[j]) {
							base[j] = false; // 현재 베이스 false	
							
							// 다음 이동할 베이스가 4(홈) 이상이 되면 점수 획득
							if (nextB >= 4) {
								score++;
								continue;
							}
							
							base[nextB] = true; // 이동한 베이스 true	
						}
					}
					
					// 홈런이 아니면 타자 진루 체크, 홈런이면 점수 1 증가
					if (val < 4) base[val] = true;
					else score++;
				}
				
				if (++batterIdx == 10) batterIdx = 1;
				
				if (outCnt == 3) break;
			}
		}
		
		return score;
	}
	
	static void Permu(int idx) {
		if (idx == 10) {
			ans = Math.max(ans, simulation());
			return;
		}
		
		// 4번 타자는 1번 고정이므로, 다음 인덱스 바로 호출
		if (idx == 4) Permu(5);
		else {
			for (int i = 2; i <= 9; i++) {
				if (visited[i]) continue;
				visited[i] = true;
				order[idx] = i;
				Permu(idx + 1);
				visited[i] = false;
			}	
		}
	}

}