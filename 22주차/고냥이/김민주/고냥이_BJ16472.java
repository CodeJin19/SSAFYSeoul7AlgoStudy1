package week22;

import java.io.*;
import java.util.*;

public class 고냥이_BJ16472 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		String str = in.readLine();
		
		int ans = 1;
		int [] alp = new int[26];
		
		int right = 1, left = 0, cnt = 1, len=1;
		alp[str.charAt(0)-'a']++;
		
		while(left <= right && right<str.length()) {
			
			if(cnt <= N) {
				int num = str.charAt(right) - 'a';
				if(alp[num] == 0) cnt++;
				alp[num]++;
				right++;
				len++;
			}

			if(cnt > N) {
				int num = str.charAt(left) - 'a';
				if(--alp[num] == 0) cnt--; 
				left++;
				len--;
			}
			
			ans = Math.max(len, ans);
		}
		System.out.println(ans);
	}
}
