package com.ssafy.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SecretCode_Baekjoon1759 {
	static int L, C, a, b; // a:모음 세는 카운트, b: 자음 세는 카운트
	static StringBuilder sb = new StringBuilder();
	static char[] secretcode; //조합한 암호
	static char [] alp; // 주어진 문자들
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		StringTokenizer str = new StringTokenizer(in.readLine()," ");
		alp = new char[C];
		for(int i=0; i<C; i++) {
			alp[i] = str.nextToken().charAt(0);
		}
		Arrays.sort(alp); // 알파벳 순으로 출력해야되니까 정렬
		Combination(0, new char[L], 0, new boolean[C]);
		System.out.println(sb);
	}
	private static void Combination(int toSelect, char[] secretcode, int startIdx, boolean[] visited) {
		if(toSelect == L) {
			if(a<1 || b<2) return; // L개 만큼 뽑았을 때 모음<1, 자음<2면 X
			for (int i=0; i<L; i++) {
				sb.append(secretcode[i]);
			}
			sb.append("\n");
			return;
		}
		
		for(int i=startIdx; i<C; i++) {
			//모음,자음 카운트 세기
			if(alp[i]=='a'|| alp[i] =='e' || alp[i] == 'i' || alp[i] == 'o' || alp[i] == 'u') 
				a++;
			else b++;
			
			if(!visited[i]) {
				visited[i]=true;
				secretcode[toSelect] = alp[i];
				Combination(toSelect+1,secretcode, i,visited);
				visited[i] = false;
			}
			//이미 방문했던 알파벳이면 카운트 다시 --
			if(alp[i]=='a'|| alp[i] =='e' || alp[i] == 'i' || alp[i] == 'o' || alp[i] == 'u') 
				a--;
			else b--;
		}
		
	}
	
}
