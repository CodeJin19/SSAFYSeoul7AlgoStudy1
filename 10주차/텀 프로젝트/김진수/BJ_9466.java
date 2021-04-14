package com.ssafy.algoStudy_10;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_9466 {
	static int list[];
	static int cache[];

	public static void setCache(int idx, ArrayList<Integer> tmpList) {
		int len = tmpList.size();
		int start = 0;

		for (int i = 0; i < len; i++) {
			if (tmpList.get(i) == idx) {
				start = i;
				break;
			} else {
				cache[tmpList.get(i)] = -1;
			}
		}

		for (int i = start; i < len; i++)
			cache[tmpList.get(i)] = 1;
	}

	public static void solve(int idx, ArrayList<Integer> tmpList) {
		int len = tmpList.size();

		for (int i = 0; i < len; i++) {
			if (tmpList.get(i) == idx) {
				setCache(idx, tmpList);
				return;
			}
		}

		tmpList.add(idx);

		if (cache[list[idx]] == 0) {
			solve(list[idx], tmpList);
		} else {
			for (int i = 0; i < len + 1; i++) {
				cache[tmpList.get(i)] = -1;
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;
		ArrayList<Integer> tmpList;
		int T = Integer.parseInt(reader.readLine());
		int n, cnt;

		for (int itr = 0; itr < T; itr++) {
			sb = new StringBuilder();
			n = Integer.parseInt(reader.readLine());
			list = new int[n + 1];
			cache = new int[n + 1];

			st = new StringTokenizer(reader.readLine());

			for (int i = 1; i <= n; i++)
				list[i] = Integer.parseInt(st.nextToken());

			for (int i = 1; i <= n; i++) {
				if(list[i] == i) {
					cache[i] = 1;
				} else if (cache[i] == 0) {
					tmpList = new ArrayList<Integer>();
					solve(i, tmpList);
				}
			}

			cnt = 0;

			for (int i = 1; i <= n; i++)
				if (cache[i] == -1)
					cnt++;

			sb.append(cnt);
			System.out.println(sb);
		}
	}
}
