package com.ssafy.programmers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 불량사용자_PG64064 {

	static String [] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
	static String [] banned_id = {"fr*d*", "*rodo", "******", "******"};
	static int answer = 0;
	static Set<String> set= new HashSet<String>();
	static Set<Set<String>> total= new HashSet<Set<String>>();
	public static void main(String[] args) {
		Arrays.sort(user_id);
		Arrays.sort(banned_id);
		dfs(new boolean[user_id.length], 0);
		System.out.println(answer);
	}
	
	public static void dfs(boolean [] visited, int start) {
		if(set.size() == banned_id.length) {
			HashSet<String> hs = new HashSet<>(set);
			
			if(!total.contains(hs)) {
				total.add(hs);
				answer++;
			}
			return;
		}
		for(int i = start; i<banned_id.length; i++) {
			for(int j = 0; j<user_id.length; j++) {
				if(check(user_id[j],banned_id[i]) && !visited[j]) {
					visited[j] = true;
					set.add(user_id[j]);
					dfs(visited, i+1);
					visited[j] = false;
					set.remove(user_id[j]);
				}
			}
			
		}
		
	}
	
	public static boolean check(String user, String banned) {
		if(user.length() != banned.length()) return false;
		
		for(int i = 0; i<banned.length(); i++) {
			if(banned.charAt(i) == '*') continue;
			if(user.charAt(i) != banned.charAt(i)) return false;
		}
		
		return true;
	}
}
