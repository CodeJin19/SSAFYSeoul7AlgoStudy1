package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 야구공_BJ17281 {

	static int N, score, max_score;
	static int [][] result; //각 선수가 이닝에서 얻는 결과
	
	static int [] order; //타순 담은 배열
	static boolean [] visited; //타순 정할때 사용
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		result = new int[N+1][10];
		visited = new boolean[10];
		order = new int[10];
		visited[4] = true;
		order[4] = 1; //4번 타자는 1번 선수로 고정
		for(int i = 1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int j = 1; j<10; j++) {
				result[i][j] = Integer.parseInt(st.nextToken());
			}
			
		}
		perm(2); // 1번 선수는 4번 타자로 고정이니까 2번선수부터 시작
		System.out.println(max_score);
	}
	
//	타순 정할 순열
	public static void perm(int toSelect) {
			
		if(toSelect == 10) {
			game();
			max_score = Math.max(score, max_score);
			return;
		}
		for(int i = 1; i<=9; i++) {
			if(!visited[i]) {
				visited[i] = true;
				order[i] = toSelect;
				perm(toSelect+1);
				visited[i] = false;
			}
		}
	}
	
//	경기
	public static void game() {
		int inning = 1; //이닝 카운트
		int out = 0; //아웃카운트 
		int player = 1; // 선수
//		int [] base = new int [4];
		boolean [] base = new boolean [4];
		score = 0;
		while(inning <= N) { // 1이닝부터 시작
			int bat = result[inning][order[player]]; // 시작 : 1이닝 1번 타자
			switch(bat) {
			case 0: //아웃
				out++; 
				break;
			case 1: //안타
				//득점권에 있었으면 점수 올리기
				if(base[3]) {
					score++;
					base[3] = false;
				}
				// 진루
				if(base[2]) {
					base[3] = true;
					base[2] = false;
				}
				if(base[1]) {
					base[2] = true;
					base[1] = false;
				}
				base[1] = true;
				break;
			case 2: //2루타
				// 득점권에 있었으면 점수 올리기
				if(base[2]) {
					score++;
					base[2] = false;
				}
				if(base[3]) {
					score++;
					base[3] = false;
				}
				// 진루
				if(base[1]) {
					base[3] = true;
					base[1] = false;
				}
				base[2] = true;
				break;
			case 3: //3루타
				// 득점권에 있었으면 점수 올리기
				if(base[1]) {
					score++;
					base[1] = false;
				}
				if(base[2]) {
					score++;
					base[2] = false;
				}
				// 진루
				if(base[3]) {
					score++;
					base[3] = false;
				}
				base[3] = true;
				break;
			case 4: //홈런
				for(int b = 1; b<=3; b++) {
					if(base[b]) {
						score++;
						base[b] = false;
					}
				}
				score++;
				break;
			default:
				break;
			
			}
			player++;
			if(player > 9) player = 1; //9번타자 넘어가면 다시 1번 타자로
			if(out == 3) {
				inning ++; //3out이면 다음 이닝
				base = new boolean[4]; //base 초기화
				out = 0; //out카운트 초기화
			}
		}
	}
	
}

