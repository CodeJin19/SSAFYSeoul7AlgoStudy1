package com.ssafy.algoStudy_10;

import java.io.*;

public class BJ_2602_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String rune = reader.readLine();
		String demon = reader.readLine();
		String angel = reader.readLine();
		int runeLen = rune.length();
		int len = demon.length();
		long demonCnt[] = new long[runeLen];
		long angelCnt[] = new long[runeLen];
		long demonAdd;
		long angelAdd;
		int demonIdx;
		int angelIdx;

		long ans = 0;

		for (int i = len - 1; 0 <= i; i--) {
			demonIdx = -1;
			demonAdd = 0;
			angelIdx = -1;
			angelAdd = 0;
			
			if (demon.charAt(i) == rune.charAt(runeLen - 1)) {
                demonAdd = 1;
                demonIdx = runeLen - 1;
			} else {
				for (int j = 0; j < runeLen - 1; j++) {
					if (demon.charAt(i) == rune.charAt(j)) {
						demonAdd = angelCnt[j + 1];
						demonIdx = j;
					}
				}
			}

			if (angel.charAt(i) == rune.charAt(runeLen - 1)) {
				angelAdd = 1;
                angelIdx = runeLen - 1;
			} else {
				for (int j = 0; j < runeLen - 1; j++) {
					if (angel.charAt(i) == rune.charAt(j)) {
						angelAdd = demonCnt[j + 1];
						angelIdx = j;
					}
				}
			}
			
			if(0 <= demonIdx)
				demonCnt[demonIdx] += demonAdd;
			
			if(0 <= angelIdx)
				angelCnt[angelIdx] += angelAdd;
		}
		
		for(int i = 0; i < runeLen; i++)
			System.out.print(demonCnt[i] + " ");
		System.out.println();
		
		for(int i = 0; i < runeLen; i++)
			System.out.print(angelCnt[i] + " ");
		System.out.println();
		ans += demonCnt[0];
		ans += angelCnt[0];

		System.out.println(ans);
	}
}
