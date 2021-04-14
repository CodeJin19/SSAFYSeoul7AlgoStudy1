package com.ssafy.algoStudy_08;

import java.util.ArrayList;
import java.util.Arrays;

public class P_72411 {
	public static String reswap(int num) {
		String ret = "";
		int idx = 0;

		idx = 0;

		while (num != 0) {
			if (num % 2 == 1)
				ret += (char) ('A' + (idx));

			num /= 2;
			idx++;
		}

		return ret;
	}

	public static int swap(String s) {
		int ret = 0;
		int l = s.length();
		for (int i = 0; i < l; i++)
			ret |= (1 << (s.charAt(i) - 'A'));
		return ret;
	}

	public static void getComb(int toSelect, int startIdx, int current, int len, boolean[] cand,
			ArrayList<Integer> list) {
		if (toSelect == len) {
			list.add(current);
			return;
		}

		for (int i = startIdx; i < 26; i++) {
			if (cand[i]) {
				current |= (1 << i);
				getComb(toSelect + 1, i + 1, current, len, cand, list);
				current ^= (1 << i);
			}
		}
	}

	public static String[] solution(String[] orders, int[] course) {
		ArrayList<String> ansTmp = new ArrayList<String>();
		ArrayList<Integer> list;
		String[] answer = {};
		int bit[] = new int[orders.length];
		int cnt[];
		int max, idx;
		int tmp = 0;
		boolean total[] = new boolean[26];

		for (int i = 0; i < orders.length; i++) {
			bit[i] = swap(orders[i]);
			tmp |= bit[i];
		}

		idx = 0;

		while (tmp != 0) {
			if (tmp % 2 == 1)
				total[idx] = true;

			tmp /= 2;
			idx++;
		}

		for (int i = 0; i < course.length; i++) {
			list = new ArrayList<Integer>();
			getComb(0, 0, 0, course[i], total, list);
			cnt = new int[list.size()];

			max = 2;

			for (int j = 0; j < cnt.length; j++) {
				for (int k = 0; k < orders.length; k++)
					if (list.get(j) == (list.get(j) & bit[k]))
						cnt[j] += 1;

				max = Math.max(max, cnt[j]);
			}

			for (int j = 0; j < cnt.length; j++)
				if (cnt[j] == max)
					ansTmp.add(reswap(list.get(j)));
		}

		answer = new String[ansTmp.size()];

		for (int i = 0; i < answer.length; i++)
			answer[i] = ansTmp.get(i);

		Arrays.sort(answer);

		return answer;
	}

	public static void main(String[] args) {
		String ans[] = solution(new String[] { "ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH" }, new int[] { 2, 3, 4 });

		for (int i = 0; i < ans.length; i++) {
			System.out.println(i + " : " + ans[i]);
		}
	}
}
