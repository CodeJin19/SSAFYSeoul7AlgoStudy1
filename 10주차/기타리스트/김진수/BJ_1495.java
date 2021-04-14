package com.ssafy.algoStudy_10;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_1495 {
	public static int solve(int idx, int list[], int now, int m) {
		if (idx == list.length)
			return now;

		int ret = 0;

		if (0 <= now - list[idx])
			ret = Math.max(ret, solve(idx + 1, list, now - list[idx], m));

		if (now + list[idx] <= m)
			ret = Math.max(ret, solve(idx + 1, list, now + list[idx], m));

		return ret;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int list[] = new int[n];

		st = new StringTokenizer(reader.readLine());

		for (int i = 0; i < n; i++)
			list[i] = Integer.parseInt(st.nextToken());

		System.out.println(solve(0, list, s, m));
	}
}
