import java.io.*;
import java.util.*;

public class BOJ_1759 {

	static int l, c;
	static char[] charStr, password;
	static String moeum = "aeiou"; // 모음 판별하기 위해 세팅
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		charStr = new char[c];
		password = new char[l];
		
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < c; i++)
			charStr[i] = st.nextToken().charAt(0);
		
		Arrays.sort(charStr); // 암호 조건이 알파벳이 증가하는 순이므로 미리 오름차순 정렬 -> 조합으로 탐색 가능
		solve(0, 0);
		
		System.out.println(sb.toString());
	}
	
	static void solve(int idx, int start) {
		if (idx == l) {
			int m = 0, j = 0;
			for (int i = 0; i < l; i++) {
				if (moeum.indexOf(password[i]) != -1) m++;
				else j++;
			}
			
			if (m >= 1 && j >= 2) {
				for (char c : password) 
					sb.append(c);
				sb.append('\n');
			}
				
			return;
		}
		
		for (int i = start; i < c; i++) {
			password[idx] = charStr[i];
			solve(idx + 1, i + 1);
		}
	}
}