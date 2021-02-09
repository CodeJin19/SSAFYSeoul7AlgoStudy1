package com.ssafy.algoStudy;

import java.io.*;

public class BJ_1918 {
	public static StringBuilder func2(String str, StringBuilder num1, int idx) throws IOException {
		StringBuilder ret = new StringBuilder();
		StringBuilder num2;

		char symbol = str.charAt(idx);
		idx++;

		if (str.charAt(idx) == '(') {
			int from = idx;
			int to;
			int cnt = 0;

			while (str.charAt(from) == '(') {
				from++;
				cnt++;
			}

			to = from;

			while (cnt != 0) {
				if (str.charAt(to) == '(')
					cnt++;
				else if (str.charAt(to) == ')')
					cnt--;
				to++;
			}

			idx = to;
			to--;

			while (str.charAt(to) == ')')
				to--;

			num2 = solve(str.substring(from, to + 1));
		} else if (idx + 1 < str.length() && (str.charAt(idx + 1) == '*' || str.charAt(idx + 1) == '/')) {
			if (symbol == '*' || symbol == '/') {
				num2 = new StringBuilder();
				num2.append(str.charAt(idx));
			} else {
				int from = idx;
				int to = from;
				int cnt = 0;

				while (true) {
					if (str.charAt(to) == '(')
						cnt++;
					else if (str.charAt(to) == ')')
						cnt--;
					else if (str.charAt(to) == '+' || str.charAt(to) == '-')
						if (cnt == 0)
							break;
					to++;
				}

				idx = to;
				to--;

				while (str.charAt(to) == ')')
					to--;

				num2 = solve(str.substring(from, to + 1));
			}

		} else {
			num2 = new StringBuilder();
			num2.append(str.charAt(idx));
		}

		ret.append(num1);
		ret.append(num2);
		ret.append(symbol);

		return ret;
	}

	public static StringBuilder func1(String str) throws IOException {
		StringBuilder ret = new StringBuilder();
		StringBuilder num1 = null;
		StringBuilder num2 = null;
		int idx = 0;
		char symbol;

		if (str.charAt(idx) == '(') {
			int from = idx;
			int to;
			int cnt = 0;

			while (str.charAt(from) == '(') {
				from++;
				cnt++;
			}

			to = from;

			while (cnt != 0) {
				if (str.charAt(to) == '(')
					cnt++;
				else if (str.charAt(to) == ')')
					cnt--;
				to++;
			}

			idx = to;
			to--;

			while (str.charAt(to) == ')')
				to--;

			num1 = solve(str.substring(from, to + 1));
		} else {
			num1 = new StringBuilder();
			num1.append(str.charAt(idx));
			idx++;
		}

		symbol = str.charAt(idx);
		idx++;

		if (str.charAt(idx) == '(') {
			int from = idx;
			int to;
			int cnt = 0;

			while (str.charAt(from) == '(') {
				from++;
				cnt++;
			}

			to = from;

			while (cnt != 0) {
				if (str.charAt(to) == '(')
					cnt++;
				else if (str.charAt(to) == ')')
					cnt--;
				to++;
			}

			idx = to;
			to--;

			while (str.charAt(to) == ')')
				to--;

			num2 = solve(str.substring(from, to + 1));
		} else if (idx + 1 < str.length() && (str.charAt(idx + 1) == '*' || str.charAt(idx + 1) == '/')) {
			if (symbol == '*' || symbol == '/') {
				num2 = new StringBuilder();
				num2.append(str.charAt(idx));
			} else {
				int from = idx;
				int to = from;
				int cnt = 0;

				while (true) {
					if (str.charAt(to) == '(')
						cnt++;
					else if (str.charAt(to) == ')')
						cnt--;
					else if (str.charAt(to) == '+' || str.charAt(to) == '-')
						if (cnt == 0)
							break;
					to++;
				}

				idx = to;
				to--;

				while (str.charAt(to) == ')')
					to--;

				num2 = solve(str.substring(from, to + 1));
			}

		} else {
			num2 = new StringBuilder();
			num2.append(str.charAt(idx));
		}

		ret.append(num1);
		ret.append(num2);
		ret.append(symbol);

		return ret;
	}

	public static StringBuilder solve(String str) throws IOException {
		StringBuilder ret = null;
		int len = str.length();
		int cnt = 0;

		for (int i = 0; i < len; i++)
			if (str.charAt(i) == '(' || str.charAt(i) == ')')
				cnt++;
		len -= cnt;

		ret = func1(str);

		while (ret.length() != len) {
			ret = func2(str, ret, ret.length());
		}

		return ret;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder ans = null;
		String str = reader.readLine();
		int len = str.length();

		ans = solve(str);

		System.out.println(ans);
	}
}
