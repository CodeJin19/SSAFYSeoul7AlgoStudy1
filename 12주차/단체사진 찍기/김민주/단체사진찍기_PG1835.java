package com.ssafy.programmers;

public class 단체사진찍기_PG1835 {
	static String ch = "ACFJMNRT";
	static String[] data = {"N~F=0", "R~T>2"};
	static int count = 0;
	static int n = 2;
	
	public static void main(String[] args) {
		perm(0, new char[8], new boolean[8]);
		System.out.println(count);
	}
	
	public static void perm(int cnt, char[]select, boolean[] visited) {
		if(cnt == 8) {
			if(check(String.valueOf(select))) 
				count++;
			return;
		}
		
		for(int i = 0; i<8; i++) {
			if(!visited[i]) {
				select[cnt] = ch.charAt(i);
				visited[i] = true;
				perm(cnt+1, select, visited);
				visited[i] = false;
			}
		}
	}
	
	public static boolean check(String str) {
		for(int i = 0; i<n; i++) {
			char ch1 = data[i].charAt(0);
			char ch2 = data[i].charAt(2);
			char condition = data[i].charAt(3);
			int num = data[i].charAt(4)-'0';
			
			int abs = Math.abs(str.indexOf(ch1)-str.indexOf(ch2))-1;
			if(condition == '=') {
				if(abs != num) return false;
			}
			else if(condition == '<') {
				if(abs >= num) return false;
			}
			else {
				if(abs <= num) return false;
			}
			
		}
		
		return true;
	}
}
