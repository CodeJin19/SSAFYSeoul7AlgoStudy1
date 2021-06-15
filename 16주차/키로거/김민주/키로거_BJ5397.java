package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 키로거_BJ5397 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringBuilder sb = new StringBuilder();
			String str = in.readLine();
			int L = str.length();
			Stack<Character> pwd = new Stack<>();
			Stack<Character> temp = new Stack<>();
			for (int i = 0; i < L; i++) {
				char ch = str.charAt(i);
				if (ch == '<') {
					if (!pwd.isEmpty()) {
						temp.add(pwd.pop());
					}
				} else if (ch == '>') {
					if (!temp.isEmpty())
						pwd.add(temp.pop());
				} else if (ch == '-') {
					if (!pwd.isEmpty())
						pwd.pop();
				} else {
					pwd.add(ch);
				}
			}
			while (!temp.isEmpty()) {
				pwd.add(temp.pop());
			}
			for(int i = 0; i<pwd.size(); i++) {
				sb.append(pwd.get(i));
			}
			System.out.println(sb);
		}
	}
}
