package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 텀프로젝트_BJ9466 {

	static int n, cnt;
	static int[] student;
	static boolean[] check;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			n = Integer.parseInt(in.readLine());
			student = new int[n + 1];
			check = new boolean[n + 1];
			visited = new boolean[n + 1];
			cnt = 0;
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int i = 1; i <= n; i++) {
				student[i] = Integer.parseInt(st.nextToken());
				if (student[i] == i) {
					check[i] = true; // 사이클이 본인 혼자 돌면 우선 체크
					cnt++;
				}
			}
			for (int i = 1; i <= n; i++) {
				dfs(i);
			}

			System.out.println(n - cnt);
		}
	}

	public static void dfs(int x) {
		if (check[student[x]] || check[x])
			return; // 이미 사이클 형성 되어있으면 바로 return

		visited[x] = true;
		if (!visited[student[x]])
			dfs(student[x]); // 현재 학생이 가리키는 학생 탐색
		else {
			if (!check[student[x]]) {
				cnt++;
//				사이클을 이루는 간선의 수 cnt++
				for (int i = student[x]; i != x; i = student[i]) {
//					System.out.println("student[x] = "+i);
//					student[6] = 4. => i=4
//					그 다음 i는 student[i] = student[4] = 7
//					그 다음 i는 studnet[i] = student[7] = 6
//					i = 6이니까 종료
					cnt++;
				}
			}
		}

		check[x] = true;
	}
}
